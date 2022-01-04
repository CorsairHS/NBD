object cw2 {
  def main(args: Array[String]): Unit = {

    //zad1
    def dzien(day: String) = day match {
      case "Poniedziałek"|"Wtorek"|"Środa"|"Czwartek"|"Piątek" => println ("Praca")
      case "Sobota"|"Niedziela" => println ("Weekend")
      case _ => println ("Nie ma takiego dnia")
    }

    dzien("Poniedziałek")
    dzien("Piątek")
    dzien("Niedziela")
    dzien("Ala")

    //zad2
    class KontoBankowe (val _stanKonta: Int){
      private var stanKonta = _stanKonta
      def this(){
        this(0)
      }

      def wplata(kwota: Int): Unit ={
        stanKonta = stanKonta + kwota
        println("Wpłacone zostało: " + kwota + " zł. Stan konta wynosi: " + stanKonta)
      }

      def wyplata(kwota1: Int): Unit ={
        stanKonta = stanKonta - kwota1
        println("Wypłacone zostało: " + kwota1 + " zł. Stan konta wynosi: " + stanKonta)
      }

    }
    var kon1 = new KontoBankowe(20)
    kon1.wplata(100)
    kon1.wplata(200)
    kon1.wyplata(30)
    var kon2 = new KontoBankowe()
    println(kon2._stanKonta)


    //zad3
    class Osoba (val imie: String, val nazwisko: String)
    val osoba1 = new Osoba("Ala", "Makota")
    val osoba2 = new Osoba("Czarek", "Burak")
    val osoba3 = new Osoba ("Marek", "Kwadrat")
    val osoba4 = new Osoba ("Kasia", "Piłek")
    val osoba5 = new Osoba ("Maciej", "Piernik")
    val osoba6 = new Osoba ("Marta", "Michalska")
    val osoba7 = new Osoba ("Konrad", "Kałuża")
    val osoba8 = new Osoba ("Kordian", "Mickiewicz")

    def powitanie(osoba: Osoba) = osoba.imie match {
      case "Czarek"|"Marta" => println ("Hej")
      case "Marek"|"Ala" => println ("Cześć")
      case _ => println ("Hej")
    }
    powitanie(osoba4)
    powitanie(osoba3)
    powitanie(osoba7)

    //zad4
    def mnożenie(l: Int): Int = l*2
    def potęga3(l: Int)(f: (Int) => Int) {
      var n = 0
      var y = l
      while(n<3){
        y = f(y)
        n = n + 1
      }
      println(y)
    }

    potęga3(4)(mnożenie)
    potęga3(2)(mnożenie)
    potęga3(5)(mnożenie)

    //zad5
    class Person{
      private val _imie:String = "Ania"
      private val _nazwisko:String = "Kot"
      private val _podatek:Double = 200

      def podatek = _podatek
    }

    trait Student extends Person {
      override def podatek = 0.0
    }

    trait Pracownik extends Person {
      def pensja:Double
      override def podatek = pensja * 0.2
    }

    trait Nauczyciel extends Pracownik{
      override def podatek = 0.1 * pensja
    }

    val st1 = new Student{
      val _imie = "Aureliusz"
      val _nazwisko = "Maciąg"
      val _podatek = 25
      val pensja = 2000.00
    }
    println("Podatek studenta "+st1._imie+" "+st1._nazwisko+" wynosi "+st1.podatek+" zł.")

    val pr1 = new Pracownik{
      val _imie = "Marek"
      val _nazwisko = "Powstańczyk"
      val _podatek = 0
      val pensja = 2000.00
    }
    println("Podatek pracownika wynosi: "+ pr1.podatek + " zł.")

    val n1 = new Nauczyciel {
      val _imie = "Alicja"
      val _nazwisko = "Graczyk"
      val _podatek = 0
      val pensja = 3000.00
    }
    println("Podatek nauczyciela wynosi: "+n1.podatek+" zł.")

  }
}
