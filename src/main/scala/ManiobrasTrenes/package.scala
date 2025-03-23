package object ManiobrasTrenes {
  type Vagon = Any;
  type Tren = List[Vagon]
  type Estado = (Tren, Tren, Tren)

  trait Movimiento
  case class Uno(n:Int) extends Movimiento
  case class Dos(n:Int) extends Movimiento

  type Maniobra = List[Movimiento]

  def aplicarMovimiento(e:Estado, m:Movimiento): Estado = {
    m match {
    case Uno(n)  => n match
      case x if x > 0 =>  (e._1 take(e._1.length - n),e._1.takeRight(n) ++ e._2 ,e._3)
      case x if x < 0  => (e._1 ++ e._2.take(-n),e._2.drop(-n),e._3)
      case _ => e
    case Dos(n) => n match
      case x if x > 0 => (e._1 take(e._1.length - n),e._2,e._1.takeRight(n) ++ e._3)
      case x if x < 0  => (e._1 ++ e._3.take(-n),e._2,e._3.drop(-n))
      case _ => e
    }
  }

  def aplicarMovimientos(e:Estado, movs:Maniobra) : List[Estado] = {
    def definirEstados(e:Estado, movs:Movimiento, x:List[Estado]) : List[Estado] = {
      List(e)
    }
    definirEstados(e,movs.head,List(e))
  }

  def definirManiobra(t1:Tren,t2:Tren): Maniobra = {
    val b: Uno = Uno(1)
    val a = List(b)
    a
  }

}
