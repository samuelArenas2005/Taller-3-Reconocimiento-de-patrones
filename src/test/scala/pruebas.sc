import ManiobrasTrenes._

//Casos de prueba aplicarMovimiento
val e1:Estado = (List('a', 'b', 'c', 'd','e','f'), List(), List())

val e2 = aplicarMovimiento(e1, Uno(0)) // Estado Esperado: (List(a, b, c, d, e, f),List(),List())

val e3 = aplicarMovimiento(e2, Uno(8)) // Estado Esperado: (List(),List(a, b, c, d, e, f),List())

val e4 = aplicarMovimiento(e3, Uno(-9)) // Estado Esperado: (List(a, b, c, d, e, f),List(),List())

val e5 = aplicarMovimiento(e4, Uno(3)) // Estado Esperado: (List(a, b, c),List(d, e, f),List())

val e6 = aplicarMovimiento(e5, Uno(-1)) // Estado Esperado: (List(a, b, c, d),List(e, f),List())

val e7 = aplicarMovimiento(e6, Dos(0)) // Estado Esperado: (List(a, b, c, d),List(e, f),List())

val e8 = aplicarMovimiento(e7, Dos(5)) // Estado Esperado: (List(),List(e, f),List(a, b, c, d))

val e9 = aplicarMovimiento(e8, Dos(-6)) // Estado Esperado: (List(a, b, c, d),List(e, f),List())

val e10 = aplicarMovimiento(e9, Dos(3)) // Estado Esperado: (List(a),List(e, f),List(b, c, d))

val e11 = aplicarMovimiento(e10, Dos(-2)) // Estado Esperado: (List(a, b, c),List(e, f),List(d))

val e12 = aplicarMovimiento(e11, Uno(2)) // Estado Esperado: (List(a),List(b, c, e, f),List(d))

val e13 = aplicarMovimiento(e12, Dos(1)) // Estado Esperado: (List(),List(b, c, e, f),List(a, d))

val e14 = aplicarMovimiento(e13, Dos(2)) // Estado Esperado: (List(),List(b, c, e, f),List(a, d))

//Casos de prueba aplicarMovimientos

val movs:Maniobra = List(Uno(0), Uno(8), Uno(-9), Uno(3),
  Uno(-1),
  Dos(0),
  Dos(5),
  Dos(-6),
  Dos(3),
  Dos(-2),
  Uno(2),
  Dos(1),
  Dos(2)
)

val movs2:Maniobra = List(Uno(3))
val movs3:Maniobra = List(Dos(2),Uno(-1))

val estado2 : Estado = (List('a', 'b'), List('e','f'), List( 'c', 'd'))
val estado3 : Estado = (Nil,Nil,Nil)

aplicarMovimientos(e1,movs)
aplicarMovimientos(e1,movs2)
aplicarMovimientos(estado2,movs3)
aplicarMovimientos(estado3,movs3)



