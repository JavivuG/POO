# Programación Orientada a Objetos

Modelo en Java de un sistema de alquiler y reserva de bicicletas urbanas, con puntos de aparcamiento, anclajes, tipos de bici, packs y pruebas JUnit.

> Asignatura **Programación Orientada a Objetos** · 2º curso, 1º cuatrimestre · curso 2021-2022 · Grado en Ingeniería Informática, Universidad de Valladolid.

## Qué hace

- **`CityBikeSystem`** gestiona los puntos de aparcamiento: altas, bajas y búsquedas por identificador. También localiza los puntos con bicis disponibles, con anclajes vacíos o situados dentro de un radio alrededor de una posición GPS.
- **`CityBikeParkingPoint`** gestiona sus anclajes y permite alquilar, reservar y devolver bicis o packs. La fianza se cobra y se reembolsa en una `TarjetaMonedero`, una librería externa que proporcionaba la asignatura.
- **`CoordenadaParkingPoint`** guarda coordenadas en grados decimales o en grados, minutos y segundos, y calcula distancias entre ellas con la fórmula del haversine.
- **Tipos de recurso:** `AdultBike`, `ChildBike`, `ElectricBike` (con `BateriaBike`), `FamilyPack` y `GroupPack`. Cada uno calcula su fianza de una forma distinta.

## Tecnologías

- Java (proyecto de Eclipse, JavaSE-11)
- JUnit 4
- Javadoc

## Aspectos técnicos destacados

- **Polimorfismo mediante la interfaz `Resource`** (`getDepositToPay`), que implementan las clases abstractas `Bike` y `Pack`. El alquiler aplica la fianza de cada recurso sin saber de qué tipo es:
  - bici infantil: 85 % de la fianza;
  - bici eléctrica: recargo del 24 %, 36 % o 48 % según el voltaje de la batería;
  - pack familiar: 50 % de la suma de las fianzas;
  - pack de grupo: 80 % de la suma de las fianzas.
- **Herencia en varios niveles:** `ElectricBike extends AdultBike extends Bike`.
- **Invariantes de los packs** protegidos con excepciones. Un `FamilyPack` no puede bajar de 4 bicis ni de 2 infantiles, un `GroupPack` no puede bajar de 10 y ningún pack admite bicis repetidas.
- **Validación sistemática** de los argumentos (`IllegalArgumentException`) y del estado (`IllegalStateException`), por ejemplo cuando la tarjeta no tiene saldo suficiente o el anclaje está vacío o reservado.
- Se redefinen `equals`, `toString` y `clone` en todo el modelo.
- **48 pruebas JUnit** en `practica2Test` (`AdultBikeTest`, `GroupPackTest` y `PolimorfismoTest`).
- La documentación Javadoc generada está en [`entrega1-jagarci-fralomo/doc/index.html`](entrega1-jagarci-fralomo/doc/index.html).

## Estructura del repositorio

```
POO/
└── entrega1-jagarci-fralomo/        # proyecto de Eclipse
    ├── src/uva/poo/
    │   ├── practica1/               # sistema, puntos de aparcamiento, anclajes, coordenadas
    │   ├── practica2/               # Resource, Bike y Pack con sus subclases
    │   └── practica2Test/           # pruebas JUnit 4
    ├── lib/                         # TarjetaMonedero.class (librería de la asignatura)
    ├── bin/                         # clases compiladas
    └── doc/                         # Javadoc
```

## Requisitos

- JDK 11 o superior
- JUnit 4 (`junit-4.x.jar` y `hamcrest-core-1.3.jar`), solo para ejecutar las pruebas

## Cómo compilar y ejecutar

El proyecto se puede importar directamente en Eclipse (*File → Import → Existing Projects into Workspace*). Desde la línea de comandos:

```bash
cd entrega1-jagarci-fralomo
javac -d out -cp "lib:junit-4.13.2.jar" $(find src -name "*.java")
java -cp "out:lib:junit-4.13.2.jar:hamcrest-core-1.3.jar" org.junit.runner.JUnitCore \
  uva.poo.practica2Test.AdultBikeTest \
  uva.poo.practica2Test.GroupPackTest \
  uva.poo.practica2Test.PolimorfismoTest
```

Sustituye las rutas de los `.jar` por las de tu instalación de JUnit. Con JDK 17 y JUnit 4.13.2 el proyecto compila y pasan las 48 pruebas. Es una biblioteca de clases: no tiene método `main`.

## Autoría

Trabajo en pareja. Los commits y las etiquetas `@author` del código corresponden a Javier García (`jagarci`) y a `fralomo`.

---

Forma parte de [UVa-Projects](https://github.com/JavivuG/UVa-Projects).
