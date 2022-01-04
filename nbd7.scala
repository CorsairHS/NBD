object tydzien {

  def main(args: Array[String]): Unit = {
    val dniTygodnia = List("Poniedziałek","Wtorek","Środa","Czwartek","Piątek","Sobota","Niedziela")

    //zad1a
    var dniTyg = ""
    for (i<-dniTygodnia){
      dniTyg = dniTyg + i + ","
    }
    println(dniTyg.dropRight(1))

    //zad1b
    var dniTygP = ""
    for (i<-dniTygodnia if i.startsWith("P")){
      dniTygP = dniTygP + i + ","
    }
    println(dniTygP.dropRight(1))

    //zad1c
    var dniTygW = ""
    var a = 0
    while (a < dniTygodnia.length){
      dniTygW = dniTygW + dniTygodnia(a) + ","
      a = a + 1
    }
    println(dniTygW.dropRight(1))

    //zad2a
    var dniTygR = ""
    def recursion(myList: List[String]): Unit = {
      if(myList.isEmpty) {
        println(dniTygR.dropRight(1))
      }
      else {
        dniTygR = dniTygR + myList.head + ","
        recursion(myList.tail)}
    }
    recursion(dniTygodnia)

    //zad2b
    var dniTygO = ""
    def recursionOp(myList: List[String]): Unit = {
      if(myList.isEmpty) {
        println(dniTygO.dropRight(1))
      }
      else {
        dniTygO = dniTygO + myList.last + ","
        recursionOp(myList.dropRight(1))}
    }
    recursionOp(dniTygodnia)

    //zad3
    def recursionTail(myList: List[String]): Unit ={
      def recursionTail2(myList: List[String], dniTygOg: String): Unit ={
        if(myList.isEmpty) {
          println(dniTygOg.dropRight(1))
        }
        else{
          recursionTail2(myList.tail,dniTygOg + myList.head + ",")
        }
      }
      recursionTail2(myList,"")
    }
    recursionTail(dniTygodnia)

    //zad4a
    def foldl = (dniTygodnia.foldLeft("")((m: String, n: String) => m + n + ","))
    println(foldl.dropRight(1))

    //zad4b
    def foldr = (dniTygodnia.foldRight("")((m: String, n: String) => m + "," + n ))
    println(foldr.dropRight(1))

    //zad4c
    var dniTygPP = List[String]()
    for (i<-dniTygodnia if i.startsWith("P")){
      dniTygPP = dniTygPP :+ i
    }
    def foldlP = (dniTygPP.foldLeft("")((m, n)  => m + n + ","))
    println(foldlP.dropRight(1))

    //zad5
    val products : Map[String,Int] = Map("Koszula" -> 130, "T-shirt" -> 40, "Jeans" -> 100, "Sweter" -> 120)
    println(products)
    val products2 = products.mapValues(x => x * 0.9).toMap
    println(products2)

    //zad6
    val tt = (Tuple3)
    println(tt("Adrian", true, 0.3))

    //zad7
    val kod_kraju = Map("PL" -> "Polska", "IT" -> "Włochy", "NL" -> "Holandia", "DE" -> "Niemcy")
    println("PL to kod kraju " + kod_kraju.get("PL"))
    println("NL to kod kraju " + kod_kraju.get("NL").getOrElse("żadnego"))
    println("XY to kod kraju " + kod_kraju.get("XY"))
    println("XY to kod kraju " + kod_kraju.get("XY").getOrElse("żadnego"))


    //zad8
    var lista = List(0,1,0,2,4,5,1,0)
    def usun0(myList: List[Int]): List[Int] = myList match{
      case Nil => Nil
      case h :: t =>
        if (h == 0){
          usun0(t)
        }
        else{
          h :: usun0(t)
        }
    }
    println(usun0(lista))

    //zad9
    val calkowite = List(1, 4, 11, 3, 5).map(x=>x+1)
    println(calkowite)

    //zad10
    val rzeczywiste = List(-14, 6.66, -6, 2, 19, -2.13, 154, -3, 3, 12, -5)
    println((rzeczywiste filter (x => -6 < x && x < 12)).map(x=>x.abs))

  }
}
