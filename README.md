###Novinky

*Uvolněna finální verze 4.8.2 pod označením Kramerius 4.8 CDK*

(pro napojení na vývojové práce ČDK je vyžadována verze 4.8), 

----

#Kramerius 4 

je softwarové řešení pro zpřístupnění digitálních dokumentů. Primárně je určen pro digitalizované knihovní sbírky, monografie a periodika. Využit může být ke zpřístupnění dalších typů dokumentů např. map, hudebnin a starých tisků, případně částí dokumentů jako jsou články a kapitoly. Systém je vhodný také pro tzv. digital born dokumenty, tedy dokumenty, které vznikly v elektronické podobě. Kramerius je průběžně upravován tak, aby struktura metadat odpovídala standardům vyhlašovaným Národní knihovnou České republiky. Systém poskytuje rozhraní pro přístup koncových uživatelů, zajišťující vyhledávání v metadatech a v plných textech, generování vícestránkových PDF dokumentů z vybraných stran, vytváření virtuálních sbírek a další operace nad uloženou sbírkou digitálních dokumentů.

Aktuální verze 4 je vyvíjena a průběžně publikována od roku 2009. Navazuje funkčností na předchozí verzi systému Kramerius končící označením 3.3.1. Nově je jako jádro systému použit open source repozitář [Fedora](http://www.fedora-commons.org). Při vývoji jsou využívány další volně dostupné technologie třetích stran - Apache, Apache Tomcat, Apache Solr, Postgres SQL. Systém je založen na technologii Java a lze ho provozovat jako samostatnou webovou aplikaci v libovolném J2EE kontejneru (např. Apache Tomcat).

Uživatelské rozhraní je přístupné ve většině moderních webových prohlížečů, vývoj a testování probíhá na aktuálních verzích prohlížečů Google Chrome, Firefox a Safari, uživatelská část rozhraní je funkční i v prohlížečích Internet Explorer 8, 9 a 10.


##Vývojový tým

Vývojový tým tvoří zaměstnanci Knihovny AV ČR, Národní knihovny ČR, Moravské zemské knihovny v Brně, Národní technické knihovny a Národní lékařské knihovny. Technologickým partnerem je na základě výběrového řízení firma INCAD, s.r.o.

Členové vývojového týmu:
KNAV - M. Lhoták, M. Duda, I. Šlapáková; 
NK ČR – P. Uhlíř, K. Kříž, T. Foltýn, J. Polišenský; 
MZK – P. Švástová, P. Žabička, M. Řehánek; 
NTK – J. Řihák, M. Janíček; 
NLK – F. Kříž; 
INCAD – P. Kocourek, V. Lahoda

Koordinátorem současného vývoje je Knihovna Akademie věd ČR zastoupená ředitelem Ing. Martinem Lhotákem.

Kontakt:
Ing. Martin Lhoták,
Knihovna AV ČR, v. v. i.,
Národní 3, 115 22 Praha 1

lhotak@knav.cz



##Financování

V současné době je na roky 2012 - 2015 financování vývoje zajištěno díky projektu "Česká digitální knihovna a nástroje pro zajištění komplexních digitalizačních procesů" - DF12P01OVV002 z Programu aplikovaného výzkumu a vývoje národní a kulturní identity (NAKI) Ministerstva kultury ČR

V předchozích letech byl vývoj systému Kramerius průběžně financován z různých dotačních programů Akademie věd ČR a Ministerstva kultury ČR. 


##Instalace
Instalační balík je k dispozici v sekci Downloads.

Kompletní dokumentace k aktuální verzi je v sekci Wiki, archiv dokumentačních wiki stránek pro starší verze je uložen jako zip soubory v sekci Downloads, historie změn wiki je přístupná přes úložiště SVN (sekce Source).


##Komunikace
Hlášení o chybách a požadavky na novou funkcionalitu zadávejte pomocí formuláře New Issue v sekci Issues. Pole Status nastavte na New, pole Owner nevyplňujte. Nastavte prioritu požadavku:

* Critical - pro požadavky vyžadující okamžitou reakci a vytvoření záplaty pro aktuální verzi
* Medium - pro požadavky vyžadující řešení v nejbližší plánované verzi
* Low - pro požadavky, které snesou odklad do případné pozdější verze

Při požadavku na přidání vlastní funkcionality do standardní distribuce systému Kramerius4 prosím kontaktujte administrátory projektu. Jednodušší změny v rámci existujících modulů bude možné řešit připravením patche pro Subversion, složitější úpravy bude třeba řešit individuálně.


Mailová konference pro administrátory systému Kramerius: kramerius@lib.cas.cz

První příhlášení do konference: https://mail.lib.cas.cz/mailman/listinfo/kramerius

Do mailové konference je možné posílat hlášení chyb, návrhy na vylepšení a vývoj i na přispění ke zdrojovému kódu Krameria.


##Podpora systému Kramerius 4

Systém Kramerius je opensource řešení. SW podporu poskytuje vývojový tým. Pro garantované termíny musí mít instituce uzavřenu samostatnou smlouvu o podpoře.

INSTALACE

Instalační postup a konfigurace systému jsou popsány na Wiki.

Službu instalace lze také objednat na http://www.unidata.cz/system-kramerius

Distribuovanou instalaci u společnosti Incad, která zajišťuje vývoj K4 http://www.incad.cz

SPRÁVA SYSTÉMU

Správa a dohled instalovaného systému může být zajištěna na základě individuální dohody. http://www.unidata.cz/ nebo http://www.incad.cz

Instalaci a správu systému mohou, vzhledem k licenci pod kterou je systém vyvíjen, zajišťovat i jiné subjekty.