public class Singleton {
 
  // eine private Klassenvariable vom Typ der eigenen Klasse (kann nicht von einer andeen Klasse aufgerufen werden)
  private static Singleton instance;
  
  // Privater Konstruktor, der nicht außerhalb dieser Klasse Aufgerufen werden kann
  private Singleton () {}
  
  // Statische Methode liefert einzige Instanz dieser Klasse zurück
  public static Singleton getInstance () {
    if (Singleton.instance == null) {
      Singleton.instance = new Singleton ();
    }
    return Singleton.instance;
  }
}