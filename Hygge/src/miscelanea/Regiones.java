package miscelanea;

/**
 * 
 * @author Mateo Ortiz
 *
 */

public class Regiones {
	String ciudad;
	String departamento;
	
	public Regiones(String ciudad) {
		this.ciudad = ciudad;
	}
	
	/**
	 * Ingresa un municipio de Colombia (en su mayoria sin necesidad de utilizar signos de puntuacion) y el metodo retorna el respectivo departamento
	 * del cual hace parte el municipio (con municipios con igual nombre escriba el departamento justo despues separado por espacio,
	 *  en caso contrario el programa escoje el departamento por la jerarquia en el primer digito del departamento)
	 * @param ciudad 
	 * @return departamento al cual hace parte
	 */
	public static String setDepartamento(String ciudad) {
		return clasificador(ciudad);
	}
	
	private static String clasificador(String ciudad) {
		for(int i=0; i < ciudadesAmazonas.length;i++) {
			if(ciudadesAmazonas[i].equals(ciudad.toLowerCase())) {
				return "Amazonas";
			}
		}for(int i=0; i < ciudadesAntioquia.length;i++) {
			if(ciudadesAntioquia[i].equals(ciudad.toLowerCase())) {
				return "Antioquia";
			}
		}for(int i=0; i < ciudadesArauca.length;i++) {
			if(ciudadesArauca[i].equals(ciudad.toLowerCase())) {
				return "Arauca";
			}
		}for(int i=0; i < ciudadesAtlantico.length;i++) {
			if(ciudadesAtlantico[i].equals(ciudad.toLowerCase())) {
				return "Atlantico";
			}
		}for(int i=0; i < ciudadesBolivar.length;i++) {
			if(ciudadesBolivar[i].equals(ciudad.toLowerCase())) {
				return "Bolivar";
			}
		}for(int i=0; i < ciudadesBoyaca.length;i++) {
			if(ciudadesBoyaca[i].equals(ciudad.toLowerCase())) {
				return "Boyaca";
			}
		}for(int i=0; i < ciudadesCaldas.length;i++) {
			if(ciudadesCaldas[i].equals(ciudad.toLowerCase())) {
				return "Caldas";
			}
		}for(int i=0; i < ciudadesCaqueta.length;i++) {
			if(ciudadesCaqueta[i].equals(ciudad.toLowerCase())) {
				return "Caqueta";
			}
		}for(int i=0; i < ciudadesCasanare.length;i++) {
			if(ciudadesCasanare[i].equals(ciudad.toLowerCase())) {
				return "Casanare";
			}
		}for(int i=0; i < ciudadesCauca.length;i++) {
			if(ciudadesCauca[i].equals(ciudad.toLowerCase())) {
				return "Cauca";
			}
		}for(int i=0; i < ciudadesCesar.length;i++) {
			if(ciudadesCesar[i].equals(ciudad.toLowerCase())) {
				return "Cesar";
			}
		}for(int i=0; i < ciudadesChoco.length;i++) {
			if(ciudadesChoco[i].equals(ciudad.toLowerCase())) {
				return "Choco";
			}
		}for(int i=0; i < ciudadesCordoba.length;i++) {
			if(ciudadesCordoba[i].equals(ciudad.toLowerCase())) {
				return "Cordoba";
			}
		}for(int i=0; i < ciudadesCundinamarca.length;i++) {
			if(ciudadesCundinamarca[i].equals(ciudad.toLowerCase())) {
				return "Cundinamarca";
			}
		}for(int i=0; i < ciudadesGuainia.length;i++) {
			if(ciudadesGuainia[i].equals(ciudad.toLowerCase())) {
				return "Guainia";
			}
		}for(int i=0; i < ciudadesGuaviare.length;i++) {
			if(ciudadesGuaviare[i].equals(ciudad.toLowerCase())) {
				return "Guaviare";
			}
		}for(int i=0; i < ciudadesHuila.length;i++) {
			if(ciudadesHuila[i].equals(ciudad.toLowerCase())) {
				return "Huila";
			}
		}for(int i=0; i < ciudadesLaGuajira.length;i++) {
			if(ciudadesLaGuajira[i].equals(ciudad.toLowerCase())) {
				return "La Guajira";
			}
		}for(int i=0; i < ciudadesMagdalena.length;i++) {
			if(ciudadesMagdalena[i].equals(ciudad.toLowerCase())) {
				return "Magdalena";
			}
		}for(int i=0; i < ciudadesMeta.length;i++) {
			if(ciudadesMeta[i].equals(ciudad.toLowerCase())) {
				return "Meta";
			}
		}for(int i=0; i < ciudadesNari�o.length;i++) {
			if(ciudadesNari�o[i].equals(ciudad.toLowerCase())) {
				return "Nari�o";
			}
		}for(int i=0; i < ciudadesNSantander.length;i++) {
			if(ciudadesNSantander[i].equals(ciudad.toLowerCase())) {
				return "N. de Santander";
			}
		}for(int i=0; i < ciudadesPutumayo.length;i++) {
			if(ciudadesPutumayo[i].equals(ciudad.toLowerCase())) {
				return "Putumayo";
			}
		}for(int i=0; i < ciudadesQuindio.length;i++) {
			if(ciudadesQuindio[i].equals(ciudad.toLowerCase())) {
				return "Quindio";
			}
		}for(int i=0; i < ciudadesRisaralda.length;i++) {
			if(ciudadesRisaralda[i].equals(ciudad.toLowerCase())) {
				return "Risaralda";
			}
		}for(int i=0; i < ciudadesSanAndres.length;i++) {
			if(ciudadesSanAndres[i].equals(ciudad.toLowerCase())) {
				return "Archipi�lago de San Andres";
			}
		}for(int i=0; i < ciudadesSantander.length;i++) {
			if(ciudadesSantander[i].equals(ciudad.toLowerCase())) {
				return "Santander";
			}
		}for(int i=0; i < ciudadesSucre.length;i++) {
			if(ciudadesSucre[i].equals(ciudad.toLowerCase())) {
				return "Sucre";
			}
		}for(int i=0; i < ciudadesTolima.length;i++) {
			if(ciudadesTolima[i].equals(ciudad.toLowerCase())) {
				return "Tolima";
			}
		}for(int i=0; i < ciudadesVCauca.length;i++) {
			if(ciudadesVCauca[i].equals(ciudad.toLowerCase())) {
				return "Valle del Cauca";
			}
		}for(int i=0; i < ciudadesVaupes.length;i++) {
			if(ciudadesVaupes[i].equals(ciudad.toLowerCase())) {
				return "Vaupes";
			}
		}for(int i=0; i < ciudadesVichada.length;i++) {
			if(ciudadesVichada[i].equals(ciudad.toLowerCase())) {
				return "Vichada";
			}
		}
		return "desconocido";
	}
	
	
	
	
	
	//LISTA DE CIUDADES POR DEPARTAMETO
	//AMAZONAS

	static String[] ciudadesAmazonas = {"la victoria",
			"puerto alegria",
			"el encanto",
			"la chorrera",
			"puerto arica",
			"puerto santander",
			"miriti-parana",
			"la pedrera",
			"tarapaca",
			"puerto nari�o",
			"leticia"};
	
	//ANTIOQUIA
	static String[] ciudadesAntioquia = {"caceres","caucasia","el bagre","nechi","taraza","zaragoza","caracoli","maceo","puerto berrio","puerto nare",
			"puerto triunfo","yondo","amalfi","anori","cisneros","remedios","san roque","santo domingo","segovia","vegachi","yali","yolombo",
			"angostura","belmira","brice�o","campamento","carolina del principe","donmatias","entrerrios","gomez plata","guadalupe",
			"ituango","san andres de cuerquia","san jose de la monta�a","san pedro de los milagros","santa rosa de osos","toledo","valdivia",
			"yarumal","abriaqui","santa fe de antioquia","anza","armenia","buritica","caicedo","ca�asgordas","dabeiba","ebejico","frontino",
			"giraldo","heliconia","liborina","olaya","peque","sabanalarga","san jeronimo","sopetran","uramita","abejorral","alejandria",
			"argelia","el carmen de viboral","cocorna","concepcion","el pe�ol","el retiro", "el santuario","granada","guarne","guatape",
			"la ceja","la union","la union antioquia","marinilla","nari�o","nari�o antioquia","rionegro","san carlos","san francisco","san luis","san rafael","san vicente","sonson",
			"amaga","andes antioquia","angelopolis","betania","betulia","caramanta","ciudad bolivar","concordia","fredonia","hispania","jerico","la pintada",
			"montebello","pueblorrico","salgar","santa barbara","tamesis","tarso","titiribi","urrao","valparaiso","venecia","apartado","arboletes",
			"carepa","chigorodo","murindo","matata","necocli","san juan de uraba","san pedro de uraba","turbo","vigia del fuerte","barbosa","bello",
			"caldas","copacabana","envigado","girardota","itagui","la estrella","medellin","medell�n","itagu�","apartad�","sabaneta","chigorod�",
			"itag�i","itag��","argelia antioquia","armenia antioquia","balboa antioquia","balboa","barbosa antioquia","betulia antioquia",
			"caldas","caldas antioquia","concordia antioquia","concepcion antioquia","concepci�n antioquia","el pe�ol antioquia"};
	
	//ARAUCA
	static String[] ciudadesArauca = {"saravena","fortul","tame","arauquita","arauca","puerto rondon","cravo norte"};
	
	//ATLANTICO
	static String[] ciudadesAtlantico = {"barranquilla","baranoa","campo de la cruz","candelaria","galapa","juan de acosta","luruaco",
			"malambo","manati","palmar de varela","piojo","polonuevo","ponedera","puerto colombia","repelon","sabanagrande","sabanalarga",
			"santa lucia","santo tomas","soledad","suan","tubara","usiacuri","candelaria atlantico","candelaria atl�ntico"};
	//BOLIVAR
	static String[] ciudadesBolivar = {"cartagena","arjona","calamar","arroyohondo","clemencia","mahates","soplaviento","san cristobal",
			"san estanislao","santa catalina","turbaco","cordoba","el guamo","el carmen de bolivar","san jacinto","san juan nepomuceno",
			"magangue","pinillos","zambrano","mompox","margarita","barranco de loba","rio viejo","norosi","arsenal","morales","santa rosa del sur"
			,"simiti","calamar bolivar","calamar bol�var","cartagena de indias","c�rdoba","cordoba bol�var","cordoba bolivar","c�rdoba bolivar",
			"c�rdoba bol�var","el pe�ol bolivar","el pe�ol bol�var","el pe��n bolivar","el pe��n bol�var","el pe�on bolivar","el pe�on bol�var"};
	//BOYACA
	static String[] ciudadesBoyaca = {"combita","cucaita","motavita","oicata","samaca","siachoque","soraca","sotaquira","toca","tunja","ventaquemada",
			"el cocuy","el espino","guacamayas","guican","panqueba","labranzagrande","pajarito","paya","pisba","berbeo","miraflores","paez",
			"zetaquira","boyaca","cienaga","jenesano","nuevo colon","ramiriqui","rondon","tibana","turmeque","umbita","viracacha","garaoa",
			"macanal","pachavita","san luis de gaceno","santa maria","boavita","covarachia","la uvita","san mateo","sativanorte","sativasur",
			"soata","susacon","tipachoque","brice�o","buenavista","chiquinquira","coper","la victoria","maripi","muzo","otanche","pauna",
			"quipama","saboya","san miguel de sema","san pablo de borbur","tunungua","almeida","chivor","guateque","guayata","la capilla",
			"somondoco","sutatenza","tenza","arcabuco","chitaraque","gachantiva","moniquira","raquira","sachica","san jose de pare","santana",
			"santa sofia","tinjaca","sutamarchan","togui","villa de leyva","aquitania","cuitiva","firavitoba","gameza","iza","mongua","mongui",
			"nobsa","pesca","sogamoso","tibasosa","topaga","tota","belen","busbanza","cerinza","corrales","duitama","floresta","paipa","chita",
			"santa rosa de viterbo","tutaza","beitiva","jerico","paz de rio","socha","socota","tasco","cubara","puerto boyaca","bel�n",
			"belen boyac�","belen boyaca","bel�n boyac�","buenavista boyaca","buenavista boyac�","buenavista","caldas boyaca","caldas boyac�",
			"puerto boyac�","boyac�","g�ican","ramiriqu�"};
	//CALDAS
	static String[] ciudadesCaldas = {"filadelfia","la merced","marmato","riosucio","supia","manzanares","marquetalia","marulanda","pensilvania",
			"anserma","belalcazar","risaralda","san jose","viterbo","aguadas","aranzazu","patora","salamina","manizales","neira","chinchina","palestina",
			"la dorada","samana","norcasia"};
	//CAQUETA
	static String[] ciudadesCaqueta = {"albania","albania caqueta","albania caquet�","belen de los andquies","cartagena de chaira","curillo","el doncello","el paujil","florencia",
			"la monta�ita","morelia","puerto milan","puerto rico","san vicente del caguan","san jose del fragua","valparaiso","solano","solita",
			"florencia caqueta","florencia caquet�"};
	//CASANARE
	static String[] ciudadesCasanare = {"la salina","aguazul","yopal","nunchia","pore","hato corozal","paz de ariporo","trinidad","san luis de palenque",
			"orocue","mani","tauramena","recetor","villanueva","monterrey","sacama","chameza"};
	
	//CAUCA
	static String[] ciudadesCauca = {"buenos aires","caloto","corinto","guachene","miranda","padilla","puerto tejada","santander de quilichao",
			"suarez","villa rica","cajibio","el tambo","la sierra","morales","piendamo","popayan","popay�n","rosas","sotara","timbio","argelia"
			,"balboa","almaguer","mercaderes","patia","piamonte","san sebasti�n", "santa rosa","guapi","lopez de micay","timbiqui","timbiqu�",
			"caldono","jalambo","tiribio","torib�o","argelia cauca","bolivar","bol�var","bolivar cauca","bol�var cauca","el tambo cauca",
			"florencia cauca"};
	
	//CESAR
	static String[] ciudadesCesar = {"valledupar","aguachica","agustin codazzi","agust�n codazzi","bosconia","chimichagua","el copey","san alberto",
			"curumani","curuman�","el paso","la paz","pueblo bello","astrea","pelaya","rio de oro","tamalameque","becerril","san diego",
			"manaure balcon del cesar","gonz�lez"};
	
	//CHOCO
	static String[] ciudadesChoco = {"acandi","alto baudo","atrato","bagado","bagad�","bahia solano","bojay�","bojaya","certegui","condoto",
			"el canton de san pablo","el carmen de atrato","el carmen del darien","el litoral de san juan","istmina","jurado","jurad�",
			"lloro","llor�","medio atrato","medio baudo","medio baud�","medio san juan","novita","n�vita","nuqui","nuqu�","quibdo","quibd�",
			"rio iro","san jose del palmar","sip�","tad�","ungu�a"};
	
	//CORDOBA
	static String[] ciudadesCordoba = {"ayapel","buenavista","canalete","chim�","ceret�","chin�","cienaga de oro","ci�naga de oro","cotorra",
			"la apartada","los c�rdobas","momil","montelibano","montel�bano","monteria","monter�a","mo�itos","puerto libertador","sahag�n",
			"sahagun","santa cruz de lorica","san pelayo","tierralta","valencia","buenavista cordoba","buenavista c�rdoba"};
	
	//CUNDINAMARCA
	static String[] ciudadesCundinamarca = {"bogota","bogot�","choconta","chocont�","macheta","manta","sesquile","sesquil�","suesca","tibirita",
			"villapinz�n","villapinzon","agua de dios","girardot","guataqui","jerusalen","nilo","ricaurte","tocaima","caparrapi","guaduas",
			"puerto salgar","alban","la pe�a","la vega","nocaima","quebradanegra","san francisco","sasaima","supata","supat�","vergara",
			"villeta","gachal�","gachala","gachet�","gacheta","gama","guasca","guatavita","la calera","ubal�","bituima","guayabal de siquima",
			"san juan de rioseco","viani","medina","paratebueno","caqueza","c�queza","fomeque","f�meque","fosca","guayabetal","quetame",
			"une","el pe�on","el pe��n","la palma","pacho","san cayetano","topaipi","villagomez","cajica","cajic�","chia","ch�a","cogua",
			"cota","gachancipa","gachancip�","nemocon","sopo","sop�","tabio","tenjo","tocancipa","tocancip�","zipaquira","zipaquir�","funza",
			"el rosal","bojac�","facatativa","facatativ�","madrid","mosquera","subachoque","zipacon","zipac�n","sibate","sibat�","soacha",
			"arbelaez","cabrera","fusagasuga","fusagasug�","granada","pandi","pasca","silvania","san bernardo","tibacuy","anapoima","analaima",
			"apulo","cachipay","el colegio","la mesa","quipile","san antonio del tequendama","tena","viota","fuqueme","f�queme","guacheta",
			"guachet�","lenguazaque","simijaca","susa","sutatausa","tausa","ubate","ubat�","cabrera cundinamarca","el pe��n cundinamarca",
			"el pe�on cundinamarca"};
	
	//GUAINIA
	static String[] ciudadesGuainia = {"barrancominas","inirida","in�rida","cacahual","puerto colombia","san felipe","la guadalupe",
			"morichal nuevo","pana pana"};
	
	//GUAVIARE
	static String[] ciudadesGuaviare = {"san jose del guaviare","san jos� del guaviare","el retorno","miraflores","calamar","calamar guaviare"};
	
	//HUILA
	static String[] ciudadesHuila = {"aipe","algeciras","baraya","campoalegre","colombia","hobo","iquira","neiva","palermo","rivera",
			"santa maria","tello","teruel","villavieja","yaguar�","agrado","altamira","garzon","gigante","guadalupe","pital","suaza","tarqui",
			"la plata","n�taga","nataga","paicol","tesalia","acevedo","el�as","isnos","oporapa","palestina","pitalito","saladoblanco",
			"timana","san agustin"};
	
	//LA GUAJIRA
	static String[] ciudadesLaGuajira = {"albania","albania la guajira","albania guajira","barrancas","dibulla","distraccion","el molino","fonseca","hatonuevo","la jagua del pilar",
			"maicao","manaure","riohacha","san juan del cesar","uribia","urimita","villanueva"};
	
	//MAGDALENA
	static String[] ciudadesMagdalena= {"santa marta","sitionuevo","pueblo viejo","cienaga","ci�naga","zona bananera","el reten","el ret�n",
			"aracataca","fundaci�n","fundacion","ariguani","nueva granada","plato","tenerife","pedraza","remolino","pivijay","algarrobo",
			"cerro de san antonio","salamina","el pi�on","santa barbara de pinto","santa ana","piji�o del carmen","san zenon","guamal",
			"el banco","san sebastian de buenavista","concordia magdalena"};
	
	//META
	static String[] ciudadesMeta = {"acacias","acac�as","barranca de upia","cabuyaro","castilla la nueva","cubarral","cumaral","el calvario",
			"el dorado","fuente de oro","guamal","la macarena","la uribe","lejanias","mapirip�n","mapiripan","mesetas","puerto concordia",
			"puerto gaitan","puerto lleras","puerto l�pez","puerto rico","restrepo","san carlos de guaroa","san juan de arama","villavicencio",
			"vista hermosa"};
	
	//NARI�O
	static String[] ciudadesNari�o = {"barbacoas","el charco","francisco pizarro","la tola","magui payan","mosquera","olaya herrera",
			"roberto payan","santa barbara","tumaco","aldana","contadero","cuaspud","funes","guachucal","gualmatan","iles","ipiales",
			"potosi","potos�","puerres","pupiales","alban","arboleda","bel�n","el rosario","la cruz","la uni�n","leiva","policarpa",
			"san pablo","san pedro de cartago","taminango","buesaco","chachagui","consaca","el tambo","el pe�ol","la florida","nari�o",
			"pasto","sandona","sandon�","tangua","yacuanquer","ancuya","cumbitara","la llanada","linares","los andes","mallama","ospina",
			"providencia","samaniego","santacruz","sapuyes","tuquerres","bel�n nari�o","belen nari�o","col�n nari�o","colon nari�o",
			"c�rdoba nari�o","cordoba nari�o","el pe�ol nari�o","el tambo nari�o"};
	
	//NORTE DE SANTANDER
	static String[] ciudadesNSantander= {"arboledas","cucutilla","lourdes","salazar de las palmas","santiago","villa caro","cucuta","c�cuta",
			"el zulia","los patios","puerto santander","san cayetano","villa del rosario","bucarasica","el tarra","sardinata","tibu","tib�",
			"abrego","�brego","cachira","convencion","convenci�n","el carmen","hacar�","la esperanza","la playa de bel�n","oca�a","san calixto",
			"teorama","cacota","c�cota","pamplona","pamplonita","santo domingo de silos","bochalema","chinacota","durania","labateca"};
	
	//PUTUMAYO
	static String[] ciudadesPutumayo = {"colon","col�n","mocoa","orito","puerto asis","puerto as�s","puerto caicedo","puerto guzman",
			"puerto leguizamo","san francisco","san miguel","santiago","sibundoy","valle del aguamez","villagarz�n","colon putumayo","col�n putumayo"};
	
	//QUIND�O
	static String[] ciudadesQuindio = {"filandia","quimbaya","circasa","armenia","salento","montenegro","la tebaida","calarca","calarc�",
			"pijao","g�nova","genova","armenia quindio","armenia quind�o","buenavista quindio","buenavista quind�o"};
	
	//RISARALDA
	static String[] ciudadesRisaralda = {"mistrato","pueblo rico","guatica","gu�tica","quinchia","quinch�a","apia","belen de umbria",
			"santuario","la celia","pererira","la virginia","dosquebradas","santa rosa de cabal","marsella","balboa risaralda"};
	
	//SAN ANDRES
	static String[] ciudadesSanAndres = {"san andres","san andr�s","providencia"};
	
	//SANTANDER
	static String[] ciudadesSantander = {"bucaramanga","aguada","albania","albania santander","aractoca","barbosa","barichara","barrancabermeja","betulia","cabrera",
			"california","capitanejo","carcasi","charala","charal�","charta","cimitarra","concepcion","confines","contratacion",
			"el carmen de chucurri","el guacamayo","el playon","encino","florian","floridablanca","galan","gambita","giron","guaca",
			"guadalupe","guavata","hato","jordan","la belleza","landazuri","land�zuri","lebrija","los santos","macaravita","malaga",
			"m�laga","matanza","mogotas","ocamonte","oiba","onzaga","palmar","palmas del socorro","paramo","piedecuesta","pinchote",
			"puente nacional","puerto parra","sabana de torres","san benito","san gil","san joaquin","san miguel","san vicente de chucuri",
			"santa helena del opon","socorro","simacota","suaita","surata","tona","v�lez","velez","vetas","villanueva","zapacota","barbosa santander",
			"betulia santander","bol�var","bol�var santander","bolivar santander","cabrera santander","concepci�n santander","concepcion santander",
			"el pe��n santander","el pe�on santander"};
	
	//SUCRE
	static String[] ciudadesSucre = {"san onofre","tolu","tol�","cove�as","palmito","toluviejo","coloso","colos�","chalan","ovejas",
			"los palmitos","morroa","sincejelo","sampues","corozal","san pedro","since","sinc�","galeras","el roble","san benito abad",
			"sucre","majagual","guaranda","san marcos","la uni�n","caimito","buenavista sucre"};
	
	//TOLIMA
	static String[] ciudadesTolima = {"mariquita","honda","fresno","herveo","casab","paloc","falan","armero","villahermosa","libano","lerida",
			"l�rida","ambalema","murillo","l�bano","santa isabel","venadillo","anzoatequi","alvarado","ibague","ibagu�","piedras","coello",
			"cajamarca","rovira","valle de san juan","san luis","guamo","espinal","flandes","su�rez","melgar","carmen de apicala",
			"carmen de apical�","icononzo","cunday","villarrica","dolores","prado","purificacion","salda�a","rovira","roncesvalles","san antonio",
			"ortega","chaparral","coyaima","alpujarra","natagaima","ataco","rioblanco","planadas"};
	
	//VALLE DEL CAUCA
	static String[] ciudadesVCauca = {"buenaventura","dari�n","darien","dagua","jamundi","jamund�","cali","yumbo","la cumbre","restrepo",
			"vijes","palmira","candelaria","pradera","florida","el cerrito","ginebra","guacari","buga","yotoco","san pedro","tulua",
			"tulu�","andalucia","riofr�o","trujillo","bugalagrande","sevilla","caicedonia","zarzal","bol�var","versalles","el dovjo","toro",
			"roldanillo","obando","cartago","ulloa","alcala","alcal�","el cairo","argelia","argelia valle del cauca","argelia valle",
			"ansermanuevo","bol�var","bol�var valle","bol�var valle del cauca","bolivar","bolivar valle","bolivar valle del cauca",
			"candelaria valle","candelaria valle del cauca"};
	
	//VAUPES
	static String[] ciudadesVaupes = {"papunaua","carur�","caruru","mitu","mit�","yavarate","pacoa","taraira"};
	
	//VICHADA
	static String[] ciudadesVichada = {"santa rosalia","santa rosal�a","la primavera","puerto carre�o","cumaribo"};
}
