package com.istea.gardenapp.repository

import com.istea.gardenapp.R
import kotlinx.coroutines.delay

class Repository {

    suspend fun getPlantas() : List<Planta> {
        delay(0)
        return listOf(
            lirio,
            verdolaga,
            colaDeRaton,
            potos,
            helecho,
            rosaMistica,
            aloeVera,
            agapanto,
            clavel,
            kalanchoe,
        )
    }

    suspend fun getCuidados(signoId: String): Cuidado {
        delay(2000)
        when(signoId){
            lirio.signoId -> return cuidadoLirio
            verdolaga.signoId -> return cuidadoVerdolaga
            colaDeRaton.signoId -> return cuidadoColaDeRaton
            potos.signoId -> return cuidadoPotos
            helecho.signoId -> return cuidadoHelecho
            rosaMistica.signoId -> return cuidadoRosaMistica
            aloeVera.signoId -> return cuidadoAloeVera
            agapanto.signoId -> return cuidadoAgapanto
            clavel.signoId -> return cuidadoClavel
            kalanchoe.signoId -> return cuidadoKalanchoe
        }
        return cuidadoLirio
    }




    val lirio = Planta(
        signoId = "001",
        nombre = "Lirio Araña",
        descripcion = "El singular aspecto de las flores del lirio Araña le da gran valor ornamental para cultivar en bordes y macetas",
        temperatura = "20 - 38 ℃",
        sol = "Sol parcial",
        ilustrationId = R.drawable.i001
    )

    val verdolaga = Planta(
        signoId = "002",
        nombre = "Verdolaga",
        descripcion = "La verdolaga (Portulaca umbraticola) es la planta del verano, la que se roba todas las miradas, la que aparece con los primeros calores y se despide apenas empieza el clima otoñal.",
        temperatura = "20 - 38 ℃",
        sol = "A pleno sol",
        ilustrationId = R.drawable.i002
    )

    val colaDeRaton = Planta(
        signoId = "003",
        nombre = "Cola de ratón",
        descripcion = "La cola de ratón (Peperomia caperata) es una especie con una gran capacidad de adaptación, capaz de expandirse por todo el terreno que encuentre disponible.",
        temperatura = "20 - 38 ℃",
        sol = "Sombra total",
        ilustrationId = R.drawable.i003
    )

    val potos = Planta(
        signoId = "004",
        nombre = "Potos",
        descripcion = "El potos es una planta resistente que requiere pocos cuidados, por lo que su cultivo ornamental está tan extendido.",
        temperatura = "20 - 41 ℃",
        sol = "Sombra total",
        ilustrationId = R.drawable.i004
    )

    val helecho = Planta(
        signoId = "005",
        nombre = "Helecho",
        descripcion = "El helecho espada es una planta muy popular para ser cultivada como planta ornamental, sobre todo en macetas de interiores.",
        temperatura = "20 - 38 ℃",
        sol = "Sol parcial",
        ilustrationId = R.drawable.i005
    )

    val rosaMistica = Planta(
        signoId = "006",
        nombre = "Rosa mística",
        descripcion = "La rosa mística llena de colorido los jardines en los que es cultivada, gracias a sus flores, las cuales brotan en abundancia. Aunque se la debe cuidar de los pulgones y las arañas rojas que la pueden invadir.",
        temperatura = "20 - 35 ℃",
        sol = "A pleno sol",
        ilustrationId = R.drawable.i006
    )

    val aloeVera = Planta(
        signoId = "007",
        nombre = "Aloe vera",
        descripcion = "El aloe vera es una suculenta mundialmente reconocida por sus usos y propiedades. Originaria de la Península Arábiga, se ha extendido a lo largo del mundo.",
        temperatura = "20 - 38 ℃",
        sol = "Sol parcial",
        ilustrationId = R.drawable.i007
    )

    var agapanto = Planta(
        signoId = "008",
        nombre = "Agapanto",
        descripcion = "Las majestuosas flores del agapanto han hecho que ganara el aprecio de los jardineros. Se cultiva mucho en espacios públicos.",
        temperatura = "15 - 38 ℃",
        sol = "A pleno sol",
        ilustrationId = R.drawable.i008
    )

    val clavel = Planta(
        signoId = "009",
        nombre = "Clavel",
        descripcion = "Las llamativas flores del clavel son la flor nacional de España. Por eso no es de extrañar que el mayor productor de esta flor de fragancia intensa en Europa se encuentre en Cádiz, España.",
        temperatura = "20 - 35 ℃",
        sol = "A pleno sol",
        ilustrationId = R.drawable.i009
    )

    val kalanchoe = Planta(
        signoId = "010",
        nombre = "Kalanchoe",
        descripcion = "El gran aprecio de los jardineros por la kalanchoe se debe a sus flores que, aunque pequeñas, crecen en abundantes y coloridos racimos.",
        temperatura = "20 - 38 ℃",
        sol = "Sol parcial",
        ilustrationId = R.drawable.i010
    )

    val cuidadoLirio = Cuidado(
        planta = lirio,
        riego = " Originario de áreas costeras, lirio Araña prefiere alta humedad y un suelo constantemente húmedo. Un riego semanal apoya su crecimiento exuberante, asemejándose a su hábitat tropical.",
        poda = " Lirio Araña presenta llamativas flores blancas y largas hojas verdes. Realiza podas a principios o finales de la primavera, elimina el follaje muerto y retira las flores marchitas para mejorar su vigor.",
        propagación = " Lirio Araña se propaga mejor mediante la división de tubérculos en primavera. Una propagación exitosa se indica por las nuevas hojas y raíces."
    )
    val cuidadoVerdolaga = Cuidado(
        planta = verdolaga,
        riego = "Verdolaga florece en ambientes húmedos, similares a los tropicales, con fuertes lluvias y periodos secos. Riega cada tres semanas, asegurándote de que el suelo se seque.",
        poda = "Verdolaga prospera con podas regulares, idealmente desde principios hasta finales de primavera, promoviendo un crecimiento saludable y flores vibrantes.",
        propagación = "Verdolaga prospera mediante esquejes; utiliza tallos sanos y no florecientes de unos pocos centímetros de largo. Deja que el extremo cortado se forme una costra antes de plantar en un suelo arenoso y bien drenado."
    )

    val cuidadoColaDeRaton = Cuidado(
        planta = colaDeRaton,
        riego = "Originario de selvas tropicales, cola de ratón prefiere humedad constante y humedad moderada. Riega semanalmente mientras supervisas la humedad del suelo para prevenir la pudrición de raíces por exceso de riego.",
        poda = "Cola de ratón requiere poda de principios a finales de primavera, eliminando hojas muertas y pellizcando los tallos para un crecimiento más arbustivo.",
        propagación = "Cola de ratón florece con esquejes en primavera y verano, aunque la propagación puede ser un poco desafiante."
    )

    val cuidadoPotos = Cuidado(
        planta = potos,
        riego = "Al prosperar en alta humedad, potos necesita humedad constante y debe ser regada semanalmente. Soporta breves períodos de sequía, pero prefiere una hidratación regular para un aspecto exuberante.",
        poda = "Potos es una planta robusta y rastrera con hojas en forma de corazón. Realiza podas a principios o finales de la primavera, cortando por encima de los nudos de las hojas para fomentar la plenitud y controlar el tamaño.",
        propagación = " Potos, de la familia Araceae, prospera en luz baja, ideal para entornos interiores. Para la propagación, toma un esqueje de tallo con un nodo y hojas, sumérgelo en agua para observar el crecimiento de raíces y luego trasplántalo en tierra para macetas."
    )

    val cuidadoHelecho = Cuidado(
        planta = helecho,
        riego = "Originario de ambientes húmedos, helecho espada prospera en suelo constantemente húmedo y bien drenado, sin encharcamiento. Es esencial regarlo regularmente dos veces por semana.",
        poda = "Helecho espada tiene frondas exuberantes y arqueadas. Pode a principios de primavera para eliminar frondas muertas o dañadas y gestionar su forma. Utilice herramientas esterilizadas para cortes limpios.",
        propagación = " Helecho espada presenta frondas exuberantes y arqueadas, y prospera en interiores con un cuidado mínimo. La propagación se realiza por división utilizando herramientas esterilizadas."
    )

    val cuidadoRosaMistica = Cuidado(
        planta = rosaMistica,
        riego = "Rosa mística florece en condiciones cálidas y lluviosas, necesitando riego dos veces por semana para un crecimiento óptimo. Esta hierba anual de floración es mejor cultivada al aire libre en la temporada cálida, beneficiándose de la lluvia natural para un desarrollo saludable.",
        poda = "Rosa mística prospera con una poda estratégica; pellizca las puntas a principios de primavera para promover ramificaciones y elimina las flores marchitas para conseguir una floración continua.",
        propagación = "Rosa mística florece sembrándose en un suelo bien drenado con humedad constante. La siembra superficial ayuda a la germinación; el espaciado adecuado asegura circulación de aire."
    )

    val cuidadoAloeVera = Cuidado(
        planta = aloeVera,
        riego = "Originario de regiones áridas, aloe vera presenta una alta tolerancia a la sequía y requiere un riego mínimo, generalmente una vez cada tres semanas.",
        poda = " Aloe vera requiere mínimas podas, limitadas a la eliminación de tallos de flores marchitas y hojas muertas o descoloridas.",
        propagación = "La propagación de aloe vera implica una técnica sencilla de esquejes. Corta una hoja sana cerca del tallo y déjala curar. Coloca el esqueje en tierra con buen drenaje y con humedad y calor constantes."
    )

    val cuidadoAgapanto = Cuidado(
        planta = agapanto,
        riego = "Originaria de Sudáfrica, agapanto prospera en suelos bien drenados y en un clima subtropical. Es moderadamente tolerante a la sequía, necesitando riego cada 1-2 semanas, permitiendo que el suelo se seque ligeramente entre riegos.",
        poda = " Poda agapanto a principios de la primavera o a finales del invierno para mejorar la floración y fomentar el crecimiento. Elimina las hojas muertas y los tallos de flores marchitas, pero evita cortar el follaje verde.",
        propagación = " Agapanto es una planta perenne que se propaga de manera efectiva por división. Separa los grupos en secciones, asegurando raíces y brotes saludables."
    )

    val cuidadoClavel = Cuidado(
        planta = clavel,
        riego = "Originario de un clima mediterráneo, clavel prospera con humedad moderada y puede tolerar breves períodos de sequía. El riego semanal es ideal, asegurando un suelo bien drenado para prevenir la pudrición de raíces.",
        poda = "Clavel produce flores vibrantes y fragantes ideales para arreglos. Pode a principios de primavera hasta finales de primavera, eliminando tallos muertos para fomentar nuevas floraciones.",
        propagación = "Clavel es apreciado por sus flores vibrantes y su aroma agradable. Propágalo tomando esquejes de una planta saludable, asegurando que los tallos cortados tengan varios nudos."
    )

    val cuidadoKalanchoe = Cuidado(
        planta = kalanchoe,
        riego = " Kalanchoe es una suculenta resistente a la sequía originaria de Madagascar, que prospera en condiciones secas. Requiere un riego mínimo, aproximadamente una vez cada tres semanas.",
        poda = "Para mantener la forma de kalanchoe, se recomienda podar las ramas redundantes y densas en primavera y otoño. Para la propagación, corte tallos robustos con 5-6 hojas, aplique polvo de azufre en la herida y plante después de que haya cicatrizado.",
        propagación = "Kalanchoe es una suculenta perenne con flores vibrantes y hojas carnosas. Propágala utilizando esquejes sanos de tallo, permitiendo que el extremo cortado se seque antes de plantar en tierra húmeda y bien drenante."
    )
}