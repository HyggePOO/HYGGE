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
		}for(int i=0; i < ciudadesNariño.length;i++) {
			if(ciudadesNariño[i].equals(ciudad.toLowerCase())) {
				return "Nariño";
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
				return "Archipiélago de San Andres";
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
			"puerto nariño",
			"leticia"};
	
	//ANTIOQUIA
	static String[] ciudadesAntioquia = {"caceres","caucasia","el bagre","nechi","taraza","zaragoza","caracoli","maceo","puerto berrio","puerto nare",
			"puerto triunfo","yondo","amalfi","anori","cisneros","remedios","san roque","santo domingo","segovia","vegachi","yali","yolombo",
			"angostura","belmira","briceño","campamento","carolina del principe","donmatias","entrerrios","gomez plata","guadalupe",
			"ituango","san andres de cuerquia","san jose de la montaña","san pedro de los milagros","santa rosa de osos","toledo","valdivia",
			"yarumal","abriaqui","santa fe de antioquia","anza","armenia","buritica","caicedo","cañasgordas","dabeiba","ebejico","frontino",
			"giraldo","heliconia","liborina","olaya","peque","sabanalarga","san jeronimo","sopetran","uramita","abejorral","alejandria",
			"argelia","el carmen de viboral","cocorna","concepcion","el peñol","el retiro", "el santuario","granada","guarne","guatape",
			"la ceja","la union","la union antioquia","marinilla","nariño","nariño antioquia","rionegro","san carlos","san francisco","san luis","san rafael","san vicente","sonson",
			"amaga","andes antioquia","angelopolis","betania","betulia","caramanta","ciudad bolivar","concordia","fredonia","hispania","jerico","la pintada",
			"montebello","pueblorrico","salgar","santa barbara","tamesis","tarso","titiribi","urrao","valparaiso","venecia","apartado","arboletes",
			"carepa","chigorodo","murindo","matata","necocli","san juan de uraba","san pedro de uraba","turbo","vigia del fuerte","barbosa","bello",
			"caldas","copacabana","envigado","girardota","itagui","la estrella","medellin","medellín","itaguí","apartadó","sabaneta","chigorodó",
			"itagüi","itagüí","argelia antioquia","armenia antioquia","balboa antioquia","balboa","barbosa antioquia","betulia antioquia",
			"caldas","caldas antioquia","concordia antioquia","concepcion antioquia","concepción antioquia","el peñol antioquia"};
	
	//ARAUCA
	static String[] ciudadesArauca = {"saravena","fortul","tame","arauquita","arauca","puerto rondon","cravo norte"};
	
	//ATLANTICO
	static String[] ciudadesAtlantico = {"barranquilla","baranoa","campo de la cruz","candelaria","galapa","juan de acosta","luruaco",
			"malambo","manati","palmar de varela","piojo","polonuevo","ponedera","puerto colombia","repelon","sabanagrande","sabanalarga",
			"santa lucia","santo tomas","soledad","suan","tubara","usiacuri","candelaria atlantico","candelaria atlántico"};
	//BOLIVAR
	static String[] ciudadesBolivar = {"cartagena","arjona","calamar","arroyohondo","clemencia","mahates","soplaviento","san cristobal",
			"san estanislao","santa catalina","turbaco","cordoba","el guamo","el carmen de bolivar","san jacinto","san juan nepomuceno",
			"magangue","pinillos","zambrano","mompox","margarita","barranco de loba","rio viejo","norosi","arsenal","morales","santa rosa del sur"
			,"simiti","calamar bolivar","calamar bolívar","cartagena de indias","córdoba","cordoba bolívar","cordoba bolivar","córdoba bolivar",
			"córdoba bolívar","el peñol bolivar","el peñol bolívar","el peñón bolivar","el peñón bolívar","el peñon bolivar","el peñon bolívar"};
	//BOYACA
	static String[] ciudadesBoyaca = {"combita","cucaita","motavita","oicata","samaca","siachoque","soraca","sotaquira","toca","tunja","ventaquemada",
			"el cocuy","el espino","guacamayas","guican","panqueba","labranzagrande","pajarito","paya","pisba","berbeo","miraflores","paez",
			"zetaquira","boyaca","cienaga","jenesano","nuevo colon","ramiriqui","rondon","tibana","turmeque","umbita","viracacha","garaoa",
			"macanal","pachavita","san luis de gaceno","santa maria","boavita","covarachia","la uvita","san mateo","sativanorte","sativasur",
			"soata","susacon","tipachoque","briceño","buenavista","chiquinquira","coper","la victoria","maripi","muzo","otanche","pauna",
			"quipama","saboya","san miguel de sema","san pablo de borbur","tunungua","almeida","chivor","guateque","guayata","la capilla",
			"somondoco","sutatenza","tenza","arcabuco","chitaraque","gachantiva","moniquira","raquira","sachica","san jose de pare","santana",
			"santa sofia","tinjaca","sutamarchan","togui","villa de leyva","aquitania","cuitiva","firavitoba","gameza","iza","mongua","mongui",
			"nobsa","pesca","sogamoso","tibasosa","topaga","tota","belen","busbanza","cerinza","corrales","duitama","floresta","paipa","chita",
			"santa rosa de viterbo","tutaza","beitiva","jerico","paz de rio","socha","socota","tasco","cubara","puerto boyaca","belén",
			"belen boyacá","belen boyaca","belén boyacá","buenavista boyaca","buenavista boyacá","buenavista","caldas boyaca","caldas boyacá",
			"puerto boyacá","boyacá","güican","ramiriquí"};
	//CALDAS
	static String[] ciudadesCaldas = {"filadelfia","la merced","marmato","riosucio","supia","manzanares","marquetalia","marulanda","pensilvania",
			"anserma","belalcazar","risaralda","san jose","viterbo","aguadas","aranzazu","patora","salamina","manizales","neira","chinchina","palestina",
			"la dorada","samana","norcasia"};
	//CAQUETA
	static String[] ciudadesCaqueta = {"albania","albania caqueta","albania caquetá","belen de los andquies","cartagena de chaira","curillo","el doncello","el paujil","florencia",
			"la montañita","morelia","puerto milan","puerto rico","san vicente del caguan","san jose del fragua","valparaiso","solano","solita",
			"florencia caqueta","florencia caquetá"};
	//CASANARE
	static String[] ciudadesCasanare = {"la salina","aguazul","yopal","nunchia","pore","hato corozal","paz de ariporo","trinidad","san luis de palenque",
			"orocue","mani","tauramena","recetor","villanueva","monterrey","sacama","chameza"};
	
	//CAUCA
	static String[] ciudadesCauca = {"buenos aires","caloto","corinto","guachene","miranda","padilla","puerto tejada","santander de quilichao",
			"suarez","villa rica","cajibio","el tambo","la sierra","morales","piendamo","popayan","popayán","rosas","sotara","timbio","argelia"
			,"balboa","almaguer","mercaderes","patia","piamonte","san sebastián", "santa rosa","guapi","lopez de micay","timbiqui","timbiquí",
			"caldono","jalambo","tiribio","toribío","argelia cauca","bolivar","bolívar","bolivar cauca","bolívar cauca","el tambo cauca",
			"florencia cauca"};
	
	//CESAR
	static String[] ciudadesCesar = {"valledupar","aguachica","agustin codazzi","agustín codazzi","bosconia","chimichagua","el copey","san alberto",
			"curumani","curumaní","el paso","la paz","pueblo bello","astrea","pelaya","rio de oro","tamalameque","becerril","san diego",
			"manaure balcon del cesar","gonzález"};
	
	//CHOCO
	static String[] ciudadesChoco = {"acandi","alto baudo","atrato","bagado","bagadó","bahia solano","bojayá","bojaya","certegui","condoto",
			"el canton de san pablo","el carmen de atrato","el carmen del darien","el litoral de san juan","istmina","jurado","juradó",
			"lloro","lloró","medio atrato","medio baudo","medio baudó","medio san juan","novita","nóvita","nuqui","nuquí","quibdo","quibdó",
			"rio iro","san jose del palmar","sipí","tadó","unguía"};
	
	//CORDOBA
	static String[] ciudadesCordoba = {"ayapel","buenavista","canalete","chimá","cereté","chinú","cienaga de oro","ciénaga de oro","cotorra",
			"la apartada","los córdobas","momil","montelibano","montelíbano","monteria","montería","moñitos","puerto libertador","sahagún",
			"sahagun","santa cruz de lorica","san pelayo","tierralta","valencia","buenavista cordoba","buenavista córdoba"};
	
	//CUNDINAMARCA
	static String[] ciudadesCundinamarca = {"bogota","bogotá","choconta","chocontá","macheta","manta","sesquile","sesquilé","suesca","tibirita",
			"villapinzón","villapinzon","agua de dios","girardot","guataqui","jerusalen","nilo","ricaurte","tocaima","caparrapi","guaduas",
			"puerto salgar","alban","la peña","la vega","nocaima","quebradanegra","san francisco","sasaima","supata","supatá","vergara",
			"villeta","gachalá","gachala","gachetá","gacheta","gama","guasca","guatavita","la calera","ubalá","bituima","guayabal de siquima",
			"san juan de rioseco","viani","medina","paratebueno","caqueza","cáqueza","fomeque","fómeque","fosca","guayabetal","quetame",
			"une","el peñon","el peñón","la palma","pacho","san cayetano","topaipi","villagomez","cajica","cajicá","chia","chía","cogua",
			"cota","gachancipa","gachancipá","nemocon","sopo","sopó","tabio","tenjo","tocancipa","tocancipá","zipaquira","zipaquirá","funza",
			"el rosal","bojacá","facatativa","facatativá","madrid","mosquera","subachoque","zipacon","zipacón","sibate","sibaté","soacha",
			"arbelaez","cabrera","fusagasuga","fusagasugá","granada","pandi","pasca","silvania","san bernardo","tibacuy","anapoima","analaima",
			"apulo","cachipay","el colegio","la mesa","quipile","san antonio del tequendama","tena","viota","fuqueme","fúqueme","guacheta",
			"guachetá","lenguazaque","simijaca","susa","sutatausa","tausa","ubate","ubaté","cabrera cundinamarca","el peñón cundinamarca",
			"el peñon cundinamarca"};
	
	//GUAINIA
	static String[] ciudadesGuainia = {"barrancominas","inirida","inírida","cacahual","puerto colombia","san felipe","la guadalupe",
			"morichal nuevo","pana pana"};
	
	//GUAVIARE
	static String[] ciudadesGuaviare = {"san jose del guaviare","san josé del guaviare","el retorno","miraflores","calamar","calamar guaviare"};
	
	//HUILA
	static String[] ciudadesHuila = {"aipe","algeciras","baraya","campoalegre","colombia","hobo","iquira","neiva","palermo","rivera",
			"santa maria","tello","teruel","villavieja","yaguará","agrado","altamira","garzon","gigante","guadalupe","pital","suaza","tarqui",
			"la plata","nátaga","nataga","paicol","tesalia","acevedo","elías","isnos","oporapa","palestina","pitalito","saladoblanco",
			"timana","san agustin"};
	
	//LA GUAJIRA
	static String[] ciudadesLaGuajira = {"albania","albania la guajira","albania guajira","barrancas","dibulla","distraccion","el molino","fonseca","hatonuevo","la jagua del pilar",
			"maicao","manaure","riohacha","san juan del cesar","uribia","urimita","villanueva"};
	
	//MAGDALENA
	static String[] ciudadesMagdalena= {"santa marta","sitionuevo","pueblo viejo","cienaga","ciénaga","zona bananera","el reten","el retén",
			"aracataca","fundación","fundacion","ariguani","nueva granada","plato","tenerife","pedraza","remolino","pivijay","algarrobo",
			"cerro de san antonio","salamina","el piñon","santa barbara de pinto","santa ana","pijiño del carmen","san zenon","guamal",
			"el banco","san sebastian de buenavista","concordia magdalena"};
	
	//META
	static String[] ciudadesMeta = {"acacias","acacías","barranca de upia","cabuyaro","castilla la nueva","cubarral","cumaral","el calvario",
			"el dorado","fuente de oro","guamal","la macarena","la uribe","lejanias","mapiripán","mapiripan","mesetas","puerto concordia",
			"puerto gaitan","puerto lleras","puerto lópez","puerto rico","restrepo","san carlos de guaroa","san juan de arama","villavicencio",
			"vista hermosa"};
	
	//NARIÑO
	static String[] ciudadesNariño = {"barbacoas","el charco","francisco pizarro","la tola","magui payan","mosquera","olaya herrera",
			"roberto payan","santa barbara","tumaco","aldana","contadero","cuaspud","funes","guachucal","gualmatan","iles","ipiales",
			"potosi","potosí","puerres","pupiales","alban","arboleda","belén","el rosario","la cruz","la unión","leiva","policarpa",
			"san pablo","san pedro de cartago","taminango","buesaco","chachagui","consaca","el tambo","el peñol","la florida","nariño",
			"pasto","sandona","sandoná","tangua","yacuanquer","ancuya","cumbitara","la llanada","linares","los andes","mallama","ospina",
			"providencia","samaniego","santacruz","sapuyes","tuquerres","belén nariño","belen nariño","colón nariño","colon nariño",
			"córdoba nariño","cordoba nariño","el peñol nariño","el tambo nariño"};
	
	//NORTE DE SANTANDER
	static String[] ciudadesNSantander= {"arboledas","cucutilla","lourdes","salazar de las palmas","santiago","villa caro","cucuta","cúcuta",
			"el zulia","los patios","puerto santander","san cayetano","villa del rosario","bucarasica","el tarra","sardinata","tibu","tibú",
			"abrego","ábrego","cachira","convencion","convención","el carmen","hacarí","la esperanza","la playa de belén","ocaña","san calixto",
			"teorama","cacota","cácota","pamplona","pamplonita","santo domingo de silos","bochalema","chinacota","durania","labateca"};
	
	//PUTUMAYO
	static String[] ciudadesPutumayo = {"colon","colón","mocoa","orito","puerto asis","puerto asís","puerto caicedo","puerto guzman",
			"puerto leguizamo","san francisco","san miguel","santiago","sibundoy","valle del aguamez","villagarzón","colon putumayo","colón putumayo"};
	
	//QUINDÍO
	static String[] ciudadesQuindio = {"filandia","quimbaya","circasa","armenia","salento","montenegro","la tebaida","calarca","calarcá",
			"pijao","génova","genova","armenia quindio","armenia quindío","buenavista quindio","buenavista quindío"};
	
	//RISARALDA
	static String[] ciudadesRisaralda = {"mistrato","pueblo rico","guatica","guática","quinchia","quinchía","apia","belen de umbria",
			"santuario","la celia","pererira","la virginia","dosquebradas","santa rosa de cabal","marsella","balboa risaralda"};
	
	//SAN ANDRES
	static String[] ciudadesSanAndres = {"san andres","san andrés","providencia"};
	
	//SANTANDER
	static String[] ciudadesSantander = {"bucaramanga","aguada","albania","albania santander","aractoca","barbosa","barichara","barrancabermeja","betulia","cabrera",
			"california","capitanejo","carcasi","charala","charalá","charta","cimitarra","concepcion","confines","contratacion",
			"el carmen de chucurri","el guacamayo","el playon","encino","florian","floridablanca","galan","gambita","giron","guaca",
			"guadalupe","guavata","hato","jordan","la belleza","landazuri","landázuri","lebrija","los santos","macaravita","malaga",
			"málaga","matanza","mogotas","ocamonte","oiba","onzaga","palmar","palmas del socorro","paramo","piedecuesta","pinchote",
			"puente nacional","puerto parra","sabana de torres","san benito","san gil","san joaquin","san miguel","san vicente de chucuri",
			"santa helena del opon","socorro","simacota","suaita","surata","tona","vélez","velez","vetas","villanueva","zapacota","barbosa santander",
			"betulia santander","bolívar","bolívar santander","bolivar santander","cabrera santander","concepción santander","concepcion santander",
			"el peñón santander","el peñon santander"};
	
	//SUCRE
	static String[] ciudadesSucre = {"san onofre","tolu","tolú","coveñas","palmito","toluviejo","coloso","colosó","chalan","ovejas",
			"los palmitos","morroa","sincejelo","sampues","corozal","san pedro","since","sincé","galeras","el roble","san benito abad",
			"sucre","majagual","guaranda","san marcos","la unión","caimito","buenavista sucre"};
	
	//TOLIMA
	static String[] ciudadesTolima = {"mariquita","honda","fresno","herveo","casab","paloc","falan","armero","villahermosa","libano","lerida",
			"lérida","ambalema","murillo","líbano","santa isabel","venadillo","anzoatequi","alvarado","ibague","ibagué","piedras","coello",
			"cajamarca","rovira","valle de san juan","san luis","guamo","espinal","flandes","suárez","melgar","carmen de apicala",
			"carmen de apicalá","icononzo","cunday","villarrica","dolores","prado","purificacion","saldaña","rovira","roncesvalles","san antonio",
			"ortega","chaparral","coyaima","alpujarra","natagaima","ataco","rioblanco","planadas"};
	
	//VALLE DEL CAUCA
	static String[] ciudadesVCauca = {"buenaventura","darién","darien","dagua","jamundi","jamundí","cali","yumbo","la cumbre","restrepo",
			"vijes","palmira","candelaria","pradera","florida","el cerrito","ginebra","guacari","buga","yotoco","san pedro","tulua",
			"tuluá","andalucia","riofrío","trujillo","bugalagrande","sevilla","caicedonia","zarzal","bolívar","versalles","el dovjo","toro",
			"roldanillo","obando","cartago","ulloa","alcala","alcalá","el cairo","argelia","argelia valle del cauca","argelia valle",
			"ansermanuevo","bolívar","bolívar valle","bolívar valle del cauca","bolivar","bolivar valle","bolivar valle del cauca",
			"candelaria valle","candelaria valle del cauca"};
	
	//VAUPES
	static String[] ciudadesVaupes = {"papunaua","carurú","caruru","mitu","mitú","yavarate","pacoa","taraira"};
	
	//VICHADA
	static String[] ciudadesVichada = {"santa rosalia","santa rosalía","la primavera","puerto carreño","cumaribo"};
}
