import androidx.compose.runtime.mutableStateOf

object FlowersData {
    val flowerArray = arrayListOf<FlowerArray>()
    val currentFlower = mutableStateOf(FlowerArray())
    var currentCount = 0
    init {
        val array = arrayListOf<FlowerArray>()
        array.add(
            FlowerArray(
                id = 0,
                src = "https://domashniecvety.ru/wp-content/uploads/6/8/b/68b4445d4fc9914adcbdea764ef778fd.jpg",
                title = "Альстромерия",
                titleShort = "Род южноамериканских корневищных и клубневых красивоцветущих травянистых растений из семейства Альстрёмериевые. В русскоязычной литературе встречаются и другие варианты написания названия рода - «алстромерия», «альстромерия». Число видов - более ста.",
                srcArray = arrayListOf(
                    "https://lakusha.ru/upload/iblock/bec/agava.jpg",
                    "https://na-dache.pro/uploads/posts/2021-05/1620993276_20-p-agava-foto-24.jpg",
                    "https://clubcosmetics.ru/image/cache/data/Secret%20Skin/Agava1-800x800.jpg",
                    "https://na-dache.pro/uploads/posts/2021-11/1636406920_34-na-dache-pro-p-domashnii-tsvetok-agava-foto-35.jpg",
                    "https://c.pxhere.com/photos/f5/5f/photo-55050.jpg!d",
                    "https://magazin-naturalist.ru/photos/catalog_photos/20367.jpg"
                ),
                titleFull = "Из листьев многих видов агавы изготавливают канаты, верёвки, шпагат, половики, упаковочные и другие грубые ткани; из отходов производят бумагу, главным образом обёрточную. Некоторые виды агавы разводят в тропических областях обоих полушарий для получения волокна. Наиболее ценны Агава сизалевая (Agave sisalana Perrine), дающая так называемый сизаль, Агава фуркреевидная, или Юкатанская конопля (Agave fourcroydes Lem.) — генекен (юкатанский сизаль), Агава кантала (Agave cantala Roxb.) — канталу, и другие. Спрессованные волокна агавы, именуемые сизаль, обычно используют для мишеней игр дартс.\n" +
                        "\n" +
                        "Многие части агавы съедобны: листья, цветы, сердцевина и сок употребляют в пищу. На листьях обитают гусеницы бабочки из рода Megathymus, их жарят вместе с листьями и едят, считая деликатесом. Сок производят взрослые растения (с 6—8 года), зимой и весной, перед началом цветения, листья агавы наиболее им богаты, а в сезон, длящийся около двух месяцев, в день можно собрать около 0,27 литра сока. Агавовый сок сахаристый, почти прозрачный с зеленоватым оттенком, сладкий с горчинкой, его пьют как освежающий напиток и вываривают в сироп. Без консервации быстро начинает бродить: из сока агавы тёмно-зелёной (Agave atrovirens Karw. ex Salm-Dyck) и других готовят алкогольный напиток пульке и уксус, а из сердцевины агавы производят крепкие алкогольные напитки — текила и мескаль. Только Агава голубая (Agave tequilana Web.) используется для производства текилы. Для производства текилы используется сердцевина растения. Путём перегонки из сока голубой агавы делают дистиллят, он и является основой для текилы. Из стеблей Agave cocui делается традиционный венесуэльский напиток кокуй.\n" +
                        "\n" +
                        "Из некоторых видов агавы делают сладкий сироп, похожий по консистенции на мёд. Тяжёлые и крупные стрелки, которые агава выбрасывает перед цветением, жарят и употребляют в пищу.\n" +
                        "\n" +
                        "Корни некоторых агав в Мексике применяют в медицине. В листьях агавы американской и сисальской содержатся стероидные сапонины, используемые для синтеза стероидных гормональных препаратов — кортизона, прогестерона. В Китае из обоих видов получены вещества, составляющие новую группу контрацептивов, обладающих важным преимуществом — их достаточно принимать один—два раза в месяц. Агава американская (Agave americana L.) применяется в гомеопатии.\n" +
                        "\n" +
                        "Агава американская, Агава оттянутая (Agave attenuata Salm-Dyck), Агава королевы Виктории (Agave victoriae-reginae T.Moore) и многие другие разводятся как комнатные и оранжерейные растения."
            )
        )
        array.add(
            FlowerArray(
                id = 1,
                src = "https://flo.discus-club.ru/images/stories/komnatnie/aglaonema/aglaonema1.jpg",
                title = "Аглаонема",
                titleShort = "Аглаонема — комнатное декоративное растение родом из Китая, Индии и Юго-Восточной Азии. Относится к семейству Ароидные.",
                srcArray = arrayListOf(
                    "https://flo.discus-club.ru/images/stories/komnatnie/aglaonema/aglaonema6.jpg",
                    "https://flo.discus-club.ru/images/stories/komnatnie/aglaonema/aglaonema2.jpg",
                    "https://flo.discus-club.ru/images/stories/komnatnie/aglaonema/aglaonema3.jpg",
                    "https://flo.discus-club.ru/images/stories/komnatnie/aglaonema/aglaonema5.jpg",
                    "https://flo.discus-club.ru/images/stories/komnatnie/aglaonema/aglaonema8.jpg"
                ),
                titleFull = "Аглаонема – растение с пышной кроной, листья которой остаются зелеными круглый год. Родиной цветка является Юго-Восточная Азия. Прибыл он в наши широты с просторов Китая, Филиппинских островов, Новой Гвинеи, Индии или даже Суматры. Ареал ее обитания в природных условиях довольно обширен. В качестве комнатного растения аглаонема завоевала свою популярность благодаря яркости, красивому окрасу и интересным цветкам.\n" +
                        "\n" +
                        "Аглаонема относится к одному семейству Ароидные вместе с диффенбахией. Отсюда уверенность многих в том, что она такая же ядовитая, как и ее более крупнолистная сестра по семейству.\n" +
                        "\n"
            )
        )
        array.add(
            FlowerArray(
                id = 2,
                src = "https://stroy-podskazka.ru/images/article/thumb/718-0/2021/09/vse-o-verbene-ampelnoj-1.jpg",
                title = "Вербена ампельная",
                titleShort = "Вербена ампельная выращивается как однолетнее растение. Травянистый цветок чаще всего сажают в подвесные корзины, потому что стебли вербены свисают на 60 см.",
                srcArray = arrayListOf(
                    "https://greenagri.ru/image/cache/catalog/import_files/5e/4eae688cfd15dc193805444bd5a3f7d1-760x600.jpg",
                    "https://i.ytimg.com/vi/MwEIJq5hc3Y/maxresdefault.jpg",
                    "https://pro-dachnikov.com/uploads/posts/2021-11/1637546985_9-pro-dachnikov-com-p-verbena-kvarts-miks-foto-11.jpg",
                    "https://images.ua.prom.st/2964436229_w500_h500_semena-verbeny-obsession.jpg",
                    "https://img4.goodfon.ru/original/3200x1200/9/12/verbena-petuniia-verbena-petunia.jpg"
                ),
                titleFull = "Вербена относится к многолетним растениям, но в умеренных широтах она используется как однолетняя культура, поскольку перенести суровые зимние условия она не в состоянии. Побеги ампельной красавицы достигают 60 см, поэтому идеальная ее локализация — подвесное кашпо или высокая клумба. В этом случае растение образует пышный каскад, покрытый яркими цветками интенсивного окраса. Преобладающими тонами будут вишневые, синие, сиреневые, красные, лососевые, розовые, белые и еще масса промежуточных оттенков."
            )
        )
        array.add(
            FlowerArray(
                id = 3,
                src = "https://leplants.ru/static/cache/59/de/59de6fe3abe5fcf1f02585182aecd39e.jpg",
                title = "Гипоэстес",
                titleShort = "Комнатные растения оригинально украшают интерьер помещения, подчеркивая стилистику определенного дизайна. На сегодняшний день существует огромный выбор декоративных цветов, которые можно легко выращивать в домашних условиях, при этом особой популярностью у цветоводов пользуется гипоэстес. Он отличается интересной окраской, прост в уходе и позволяет наполнить комнату необычной атмосферой.",
                srcArray = arrayListOf(
                    "https://www.provenwinners.com/sites/provenwinners.com/files/imagecache/1024-max/ifa_upload/hippo_rose_mono.jpg",
                    "http://www.bloomingarden.ru/images/companies/1/Hypoestes%20Confetti%20Compact-07.jpg?1441112105464",
                    "https://cvetyportal.ru/wp-content/uploads/2018/07/gipoe%60stes-75.jpg",
                    "https://www.miodimore.ru/wp-content/uploads/2019/09/gipoehstes.jpg",
                    "https://na-dache.pro/uploads/posts/2021-05/1620294092_2-p-fittoniya-gipoestes-foto-2.jpg"
                ),
                titleFull = "Гипоэстес представляет собой красивое комнатное растение, которое было завезено в нашу страну с далекого острова Мадагаскар. Данный цветок относят к семейству Акантовых, он имеет вид разветвленного кустарника с необычной декоративной листвой, которая характеризуется яркой окраской и покрыта «радужными веснушками». Высота растения не превышает 50 см.\n" +
                        "\n" +
                        "Листья у гипоэстеса овальной формы, они могут быть как с ровными так и заостренными краями. Их длина обычно составляет от 5 до 8 см, ширина не более 4 см. Главной особенностью растения считается наличие на листве множества точек различного оттенка: красного, белого, розового, пурпурного.\n" +
                        "\n"
            )
        )
        array.add(
            FlowerArray(
                id = 4,
                src = "https://dachadecor.ru/images/dd/dd_givokost_polevaya_3.jpg",
                title = "Дельфиниум",
                titleShort = "Род однолетних и многолетних травянистых растений семейства Лютиковые. Включает около 450 видов, произрастающих в Северном полушарии и в горах тропической Африки. Многие виды происходят из Юго-Восточной Азии и особенно из Китая, где произрастает более 150 видов. Род Живокость близок к роду известных ядовитых растений Аконит.",
                srcArray = arrayListOf(
                    "https://www.plantarium.ru/dat/plants/5/543/577543_84c4dbe4.jpg",
                    "https://pro-dachnikov.com/uploads/posts/2021-11/1637433896_41-pro-dachnikov-com-p-zhivokost-klinovidnaya-foto-42.jpg",
                    "https://i.artfile.me/wallpaper/30-12-2009/1600x1200/cvety-delfinium-430215.jpg",
                    "https://pro-dachnikov.com/uploads/posts/2021-11/1637654106_30-pro-dachnikov-com-p-zhivokost-visokaya-foto-31.jpg",
                    "https://images.ru.prom.st/426922454_w640_h640_delfinium.jpg"
                ),
                titleFull = "Во всех описаниях упоминается, что это растение выглядит как свечи, образованные рядом бутонов. В зависимости от региона обитания, есть разные названия, в том числе «шпорник» и «живокость». Популярность культуры обусловлена тем, что она переносит даже очень холодные времена. Название «дельфиниум» связано с особенностями колоса – он внешне похож на голову морского дельфина. А слово «шпорник» появилось из-за характерных глазков внутри чашелистиков.\n" +
                        "\n" +
                        "Независимо от того, как называют это растение, все сходятся во мнении, что оно отлично подходит для мест со студеной зимой. И более того, даже если наступило прохладное лето, растение гарантированно раскроется во всей красоте. Это обстоятельство тоже делает дельфиниум востребованным среди садоводов средней климатической зоны России.\n" +
                        "\n" +
                        "В этих регионах встречается не менее 90 разновидностей дельфиниума. Время его жизни определяется, прежде всего, фактической погодой. В зависимости от нее, одни и те же растения могут прожить и 4 года, и 8 лет. Простые бутоны у этих цветов обычно имеют 5 лепестков.\n" +
                        "\n" +
                        "Середину занимает шпорец. Такое сочетание делает дельфиниум превосходным медоносом. Культура может опыляться шмелями либо небольшими птицами. Окраска цветков разнообразна. Однако большинство видов украшено синими либо фиолетовыми бутонами. Чем белее растение, тем обычно сильнее его запах."
            )
        )
        array.add(
            FlowerArray(
                id = 5,
                src = "https://2sotki.ru/wp-content/uploads/d/e/7/de72ab92bedf375701935ced1767ece8.jpg",
                title = "Иберис",
                titleShort = "Род травянистых растений семейства Капустные. Другие русские названия: Перечник, Стенник, Разнолепестка.",
                srcArray = arrayListOf(
                    "https://2sotki.ru/wp-content/uploads/d/e/7/de72ab92bedf375701935ced1767ece8.jpg",
                    "https://i03.tvoysad.ru/2020/06/04/IMG_20200604_09522822876afc0f20cd77.jpg",
                    "https://sun9-51.userapi.com/c858432/v858432766/1ef837/I-IYbGn4O94.jpg",
                    "https://distano.ru/wp-content/uploads/e/d/5/ed57033dadc0b93e1e6e2e4ef09ceba2.jpeg",
                    "https://i.pinimg.com/originals/e9/4f/a7/e94fa7d8997b1ab119d58168dd4607d2.jpg"
                ),
                titleFull = "Иберис является растением, которое в своем росте опирается на корень по типу стержня. По этой причине пересаживать его бывает проблематично. Побеги культуры во многом зависят от конкретного вида. Они могут быть как прямостоячими, так и стелющимися. Листва отличается простым строением. Листовые пластинки имеют маленькие размеры, характеризуются темно-зеленым окрасом. Подобный кустарник эффектно украшают соцветия, имеющие интересную форму зонтика. Они собираются из большого числа миниатюрных цветочков, диаметр коих редко превышает 1 см.\nЦвет ибериса всегда добротный и пышный. За большим количеством богатых соцветий не всегда можно легко заметить листву. Расцветка цветков находится в зависимости от конкретного сорта полукустарника. Встречаются белоснежные, лиловые, розовые, сиреневые и красные оттенки. Соцветия являются душистыми, что придает садовому участку неповторимую свежесть воздуха и особенный, манящий аромат.\nИберис отличается весьма интересным цветением. Зацветает это растение весной в мае либо в августе, обычно цветет максимально роскошно и пестро, но, к сожалению, не слишком долго – всего около 8 недель. Соцветия дают плоды, представленные в форме овального или круглого двухстороннего стручка. Если семечки высушить, их всхожесть имеет способность сохраняться на протяжении долгих 4 лет. Многие садоводы предпочитают заниматься выращиванием многолетнего ибериса из семечек. Их просто высаживают в хорошо подготовленных теплицах, после чего тщательно за ними ухаживают по всем правилам. Цветков может быть так много, что они скроют за собой всю листву."
            )
        )
        array.add(
            FlowerArray(
                id = 6,
                src = "https://www.wallpapers13.com/wp-content/uploads/2018/04/Caladium-Bulbs-Red-Flash-Large-leaves-with-light-red-hearts-and-green-edges-manage-in-hot-and-humid-places.jpg",
                title = "Каладиум",
                titleShort = "Род тропических травянистых растений семейства Ароидные. Род включает около 15 видов, встречающихся в тропической Америке. Растения образуют густой тропический подлесок. Используются в сельском хозяйстве для получения крахмала, наиболее часто - в декоративном садоводстве ради крупных ярко-окрашенных листовых лопастей разных цветов.",
                srcArray = arrayListOf(
                    "https://na-dache.pro/uploads/posts/2021-05/1620972727_79-p-kaladium-foto-101.jpg",
                    "https://ttcomm.ru/wp-content/uploads/2019/04/b6a878899e71d72e8693.jpg",
                    "https://im0-tub-ru.yandex.net/i?id=38917d16b46ccc96325f9de0442a634e-l&ref=rim&n=13&w=1080&h=1080",
                    "https://2sotki.ru/wp-content/uploads/8/f/5/8f57c5977b4b27a859c7e163d77eb81a.jpg",
                    "https://2sotki.ru/wp-content/uploads/8/f/5/8f57c5977b4b27a859c7e163d77eb81a.jpg"
                ),
                titleFull = "Каладиум – это любимое многими ценителями экзотики садовое или комнатное растение с большими нарядными листьями, имеющими разнообразную окраску. Их форму часто сравнивают с формой наконечника копья или сердца. Изрезанные прожилками листья зачастую одарены природой или селекционерами контрастной окраской, состоящей из двух оттенков. Самые распространённые цвета листьев каладиума: пурпур, жёлтый, белый, красный, зелёный. Эта лиана не имеет стебля, обладает прикорневым ростом листьев, которые со временем разрастаются и создают плотные розетки диаметральным размером до полуметра.\n" +
                        "\n" +
                        "В основании корневой системы каладиума находится кругловато-сплющенный клубень размером в диаметре 7-10 см, в верхушке которого отлично просматриваются зачатки будущего растения и чуть в стороне – одинокие заснувшие почки.\nСтоит отметить, что за цветок каладиума часто принимается его соцветие. Оно появляется вслед за открытием третьего или четвёртого листа и смотрится как солидный початок, складывающийся из женских и мужских цветов, завернутых в заострённое одеяло. Очень часто «одеяло» принимает ту же окраску, что и лиственная часть. Весь процесс наслаждения цветами обычно длится не более суток, а через 4-5 недель на месте соцветия зреют кругловатые оранжево-красные ягоды.\n" +
                        "\n" +
                        "Каладиум – это ядовитое растение. Оно опасно как при попадании в пищевод, так и просто при работе с ним."
            )
        )
        array.add(
            FlowerArray(
                id = 7,
                src = "https://avatars.mds.yandex.net/get-zen_doc/3512693/pub_60164fd07fd0a5390f35d245_601659f87fd0a5390f43170e/scale_1200",
                title = "Крокус",
                titleShort = "Шафра́н (лат. Crocus) — род многолетних клубнелуковичных травянистых растений семейства Ирисовые, или Касатиковые (Iridaceae). В литературе по декоративному цветоводству встречается заимствованное латинское название кро́кус. Его клубнелуковицы достигают 3 см в диаметре, округлые или сплюснутые, одеты чешуями, дают пучок корневых мочек, строение и окраска которых варьируются у различных видов. Стебель не развивается.",
                srcArray = arrayListOf(
                    "https://st4.depositphotos.com/17407654/27676/i/1600/depositphotos_276766260-stock-photo-colorful-crocuses-garden.jpg",
                    "https://cdn.pixabay.com/photo/2020/04/04/12/10/krokus-5002004_1280.jpg",
                    "https://im0-tub-ru.yandex.net/i?id=eb0d757828850208e537a0e9fe9e543c-l&ref=rim&n=13&w=1080&h=1080",
                    "https://photocentra.ru/images/main97/970882_main.jpg",
                    "https://img4.goodfon.ru/original/5906x3937/6/81/shafran-krokusy-zhioltye-vesna.jpg"
                ),
                titleFull = "Крокус (шафран) – это не только садовое, но и дикорастущее растение, которое можно встретить на лугах, в степях и лесах на Ближнем Востоке, в Азии, в странах Средиземноморья, а также в Европе. Эти многолетние и однолетние цветки выбирают для ареалов своего обитания зоны зимостойкости, растения хорошо переносят недостаток света и влаги. Описание у растения довольно простое: внешне цветок выглядит как бокал на ножке, состоящий из нескольких овальных лепестков.\n" +
                        "\n" +
                        "В дикой природе растения бывают по размеру низкорослыми, тогда как гибридные формы могут достигать более крупных размеров. Каждый цветок имеет желтые рыльца, поэтому растение и получило название «шафран», что в переводе с арабского языка дословно означает «желтый». Именно за желтые рыльца крокусы ценятся с точки зрения полезного применения растения, тогда как садоводы любят эти цветы за их красоту и простоту выращивания.\nКак правило, в высоту крокусы вырастают до 10-12 см, а их луковички имеют диаметр не более 3-3,5 см. Каждая луковка имеет защитные чешуйки, а также снабжена корневой мочковатой системой. Стебель у шафрана практически не выражен, основной акцент у этого растения природа сделала на цветок и остроконечную листву. Листья цветка собраны в прикорневую розетку, прорастают они из луковки под прикрытием защитных чешуек.\n" +
                        "\n" +
                        "Из одной луковки вырастает растение, которое зацветает единичным цветком, диаметр которого может быть 2-5 см, а окраска самая разнообразная: белая, лиловая, пестрая двухцветная или с овальными пятнами, розовая, желтая, бледно-сиреневая, кремовая. Цветонос у цветка короткий.\n" +
                        "\n"
            )
        )
        flowerArray.addAll(array)
    }

}

data class FlowerArray(
    val id: Int = 0,
    val src: String = "",
    val title: String = "",
    val titleShort: String = "",
    val srcArray: List<String> = emptyList(),
    val titleFull: String = ""
)