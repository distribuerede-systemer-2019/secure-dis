## 5. øvelsesgang

I dag skal vi prøve at hashe vores password på vores User-klasse. I stedet for at opbevare
kodeordet i plain-text, skal dette transformeres om til ulæseligt tekst.

#### 1. Opgave
Clone og kør dette projekt:

1. Åbn din terminal og naviger hen til mappen hvor du ønsker dette projekt skal ligge (HINT: `cd` bruges til at skifte mappe)
2. `git clone https://github.com/Distribuerede-Systemer-2017/secure-dis.git`
3. Åbn IntelliJ, lav et nyt projekt og placer projektet oven i dette repository
4. Åbn `secure-dis` mappen i IntellJ og find filen `pom.xml`
5. Højreklik på `pom.xml` og tryk "Add as Maven Project". Bruger du ikke IntelliJ, så følg guiden til installation af GSON på  Learn.
6. Hvis `pom.xml` nu er et blåt "M"-ikon, så er du færdig

#### 2. Opgave
I `src/Utility/` finder du klassen `Digester` som indeholder metoder til at hashe en string. Klassen mangler
 dog stadig at `hashWithSalt()` fungerer rigtigt. 
 
Din opgave er at færdiggøre implementering af denne metode, så den returnerer en hashed udgave af en string sammensat med et Salt 
(som vist på mit slide).

#### 3. Opgave
Da vores `Digester` klasse nu er fuldt implementeret kan vi bruge dens metoder til at hashe vores brugeres
password. 

Din opgave er at lave `setPassword()` metoden i `User`-klassen om til at den i stedet for at gemme
 kodeordet i plain tekst, i stedet kalder `hash()` eller `hashWithSalt()`, og derved gemmer kodeordet
 hashed. 
 
Du bestemmer selv hvad dit SALT skal være, og hvordan du generere det (hvis du bruger `hashWithSalt`())

#### 4. Opgave
Kør nu din Server igen, og se den hashede udgave at det password du valgte. Prøv at se om dit password
kan findes i rainbow-tabllerne på https://md5.gromweb.com/.

Hvis din hash kan findes, eksperimenter med at tilføje et tilpas avanceret SALT ind til det ikke længere
er muligt at finde i databasen.
