Fråga 1: Det kommer att behövas iteratorobjekt i flera av klassens metoder. Bör dessa skapas lokalt i resp. metod, eller räcker det med ett gemensamt iteratorobjekt i klassen som kan användas i
de olika metoderna? Skulle det fungera? Bör variabler av typen Iterator deklareras som
instansvariabler eller som lokala variabler?

Svar: Iterator objekten bör skapas lokalt i varje metod. Om man deklarerar iteratorn på som en instansvariabel så kan det leda till fel som kan vara svåra att felsöka eftersom så många metoder använder den.


Fråga 2: Har du redan löst det här problemet i en tidigare metod? Kan den ena utnyttjas i den andra? Gör det i så fall, eller förklara varför det inte
går!

Svar: Man kan tänka sig att använda sig av join då man gör en liknande jämförelse mellan email som finns i listan och den du söker efter. Men det skulle bara fungera om join metoden returnarar false när du söker för en medlem.
För annars om du söker efter en medlem som inte finns kommer den istället lägga till den medlemmen, vilket du inte vill göra.

Fråga 3:  I denna metod måste du använda en iteratorloop. I både listklassen och iteratorklassen finns metoden remove. Läs om dem i API specification. Vilken bör du använda? Vad skulle kunna hända om du använder den andra?

Svar:  Man bör använda sig av iterator.remove då det låter dig att ta bort det objektet som stämmer med jämförelsen medan du itererar i listan. Om du använder dig av list remove så kommer inte det att gå medan du itererar i listan,
då kommer du få ett ConcurrentModificationException eller liknande. 