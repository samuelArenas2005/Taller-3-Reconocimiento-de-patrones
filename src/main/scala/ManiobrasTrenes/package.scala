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
      case Uno(n)  =>
        if (n > 0) (e._1.take(e._1.length - n), e._1.drop(e._1.length - n) ++ e._2, e._3)
        else if (n < 0) (e._1 ++ e._2.take(-n), e._2.drop(-n), e._3)
        else e
      case Dos(n) =>
        if (n > 0) (e._1.take(e._1.length - n), e._2, e._1.drop(e._1.length - n) ++ e._3)
        else if (n < 0) (e._1 ++ e._3.take(-n), e._2, e._3.drop(-n))
        else e
    }
  }

  def aplicarMovimientos(e: Estado, movs: Maniobra): List[Estado] = movs match{
    case y :: Nil => e :: aplicarMovimiento(e, y) :: Nil
    case y :: ys => e :: aplicarMovimientos(aplicarMovimiento(e, y), ys)
  }

  def definirManiobra(t1:Tren,t2:Tren): Maniobra = {

    def definirMovimiento(e: Estado, movs: Maniobra, t2: Tren): Maniobra = e match{
      case (Nil, Nil, Nil) =>  movs ++ List(Uno(0))
      case (x:: xs,Nil,Nil) => {
        if ( x == t2.head ) definirMovimiento((xs,Nil,Nil),movs, t2.tail)
        else{
          val mover = e._1 dropWhile (_ != t2.head)
          definirMovimiento(aplicarMovimiento(e, Uno(mover.length)), movs ++ (Uno(mover.length) :: Nil), t2)
        }
      }
      case(y :: ys, x :: xs, Nil) => definirMovimiento(aplicarMovimiento(e, Dos(e._1.length)), movs ++ (Dos(e._1.length) :: Nil), t2 )
      case(Nil, x :: xs, y :: ys) => definirMovimiento(aplicarMovimiento(e, Uno(-e._2.length)), movs ++ (Uno(-e._2.length) :: Nil), t2 )
      case(x :: xs, Nil, y :: ys) => definirMovimiento(aplicarMovimiento(e, Dos(-e._3.length)), movs ++ (Dos(-e._3.length) :: Nil) , t2 )
    }
    definirMovimiento((t1, Nil, Nil), Nil, t2)
  }
}
