import ManiobrasTrenes._



val e1 = (List('a', 'b', 'c', 'd'), List(), List())
val e2 = aplicarMovimiento(e1, Uno(0))
val e3 = aplicarMovimiento(e2, Dos(2))
val e4 = aplicarMovimiento(e3, Uno(1))
val e5 = aplicarMovimiento(e4, Dos(-1))
val e6 = aplicarMovimiento(e5, Dos(-5))
val e7 = aplicarMovimiento(e6, Uno(-1))



val e = (List('a', 'b'), List('c'), List('d'))
aplicarMovimientos(e, List(Uno(1), Dos(1), Uno(-2)))


val ejemplo = (List('a', 'b', 'c', 'd'), List(), List())
aplicarMovimientos(ejemplo, List(Uno(4), Uno(-3), Dos(3), Uno(-1),
  Dos(-1), Uno(1), Dos(-1), Dos(-1), Uno(-1)))




definirManiobra(List('a', 'b', 'c', 'd'), List('d', 'b', 'c', 'a'))
aplicarMovimientos(ejemplo,List(Uno(1), Dos(3), Uno(-1), Dos(-3), Uno(2), Dos(1), Uno(-2), Dos(-1)) )
