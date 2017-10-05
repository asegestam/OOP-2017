Fr�ga 1: Det kommer att beh�vas iteratorobjekt i flera av klassens metoder. B�r dessa skapas lokalt i resp. metod, eller r�cker det med ett gemensamt iteratorobjekt i klassen som kan anv�ndas i
de olika metoderna? Skulle det fungera? B�r variabler av typen Iterator deklareras som
instansvariabler eller som lokala variabler?

Svar: Iterator objekten b�r skapas lokalt i varje metod. Om man deklarerar iteratorn p� som en instansvariabel s� kan det leda till fel som kan vara sv�ra att fels�ka eftersom s� m�nga metoder anv�nder den.


Fr�ga 2: Har du redan l�st det h�r problemet i en tidigare metod? Kan den ena utnyttjas i den andra? G�r det i s� fall, eller f�rklara varf�r det inte
g�r!

Svar: Man kan t�nka sig att anv�nda sig av join d� man g�r en liknande j�mf�relse mellan email som finns i listan och den du s�ker efter. Men det skulle bara fungera om join metoden returnarar false n�r du s�ker f�r en medlem.
F�r annars om du s�ker efter en medlem som inte finns kommer den ist�llet l�gga till den medlemmen, vilket du inte vill g�ra.

Fr�ga 3:  I denna metod m�ste du anv�nda en iteratorloop. I b�de listklassen och iteratorklassen finns metoden remove. L�s om dem i API specification. Vilken b�r du anv�nda? Vad skulle kunna h�nda om du anv�nder den andra?

Svar:  Man b�r anv�nda sig av iterator.remove d� det l�ter dig att ta bort det objektet som st�mmer med j�mf�relsen medan du itererar i listan. Om du anv�nder dig av list remove s� kommer inte det att g� medan du itererar i listan,
d� kommer du f� ett ConcurrentModificationException eller liknande. 