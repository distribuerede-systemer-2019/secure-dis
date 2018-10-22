

I dag skal vi prøve at hashe vores password på vores User-klasse. I stedet for at opbevare
kodeordet i plain-text, skal dette transformeres om til ulæseligt tekst.

#### 1. Opgave
Clone og kør dette projekt:

1. Åbn din terminal og naviger hen til mappen hvor du ønsker dette projekt skal ligge (HINT: `cd` bruges til at skifte mappe)
2. `git clone https://github.com/Distribuerede-Systemer-2018/secure-dis.git`
3. Åbn IntelliJ, lav et nyt projekt og placer projektet oven i dette repository
4. Åbn `secure-dis` mappen i IntellJ og find filen `pom.xml`
5. Højreklik på `pom.xml` og tryk "Add as Maven Project".
6. Hvis `pom.xml` nu er et blåt "M"-ikon, så er du færdig

#### 2. Opgave
I `src/Utility/` finder du klassen `Digester` som indeholder metoder til at hashe en string. Klassen mangler
 dog stadig at `hashWithSalt()` fungerer rigtigt. 
 
Din opgave er at færdiggøre implementering af denne metode, så den returnerer en hashed udgave af en string sammensat med et Salt.

- Se `hashWithSalt`-metoden og constructuren på `Digester`-klassen

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

- Jeg har brug saltet `S4lT` og her finder md5.groomer faktisk den rigtige værdi, så saltet er ikke "stærkt" nok

#### 5. Opgave
I Encryption-klassen kan vi kryptere strenge ud fra en given key. 

I ReponseHandler på linje 50 krypteres ordet "fodbold". Dekrypter dette uden at slette noget fra den oprindelige linje. Du må gerne tilføje.
- Se linje 50 i `ResponseHandler`

Tænk over hvad forskellen på kryptering og hashing er. Er det muligt at gøre det samme som ovenstående med hashing? Altså få en hashet værdi tilbage til det originale?
- Forskellen på hashing og kryptering er netop det. Kryptering skal kunne føres tilbage til det originale, hvor hashing har til formål at skjule en værdi.

Hvorfor bruges hashing ofte til passwords?
- Når man hasher et password, vil man altid få den samme værdi med samme hashing-algoritme (og salt). Det betyder, at passwordet ikke gemmes nogen steder, og det hermed kun er brugeren, der kender passwordet. Dette sikre også dit password, hvis et firma bliver hacket - med mindre det findes i en rainbow-table. Derfor er det vigtigt at firmaet bruger en ordentlig salt og/eller du har et stærkt password

Hvorfor er det vigtigt at en hash altid har samme længde?
- Så man ikke kan lave noget "analyse". Forestil dig, hvis du skal gætte en kodeord, og du ved at 8-karaktere altid hasher til 8-karaktere. Herved har du en vigtig information omkring kodeordet, og de mulige kombinator nedsættes drastisk!

