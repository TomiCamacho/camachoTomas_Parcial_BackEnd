# PARCIAL Back-End - Desarrollo de Software <br/> Tomás Camacho | 3K09

## Introduccion

Para la materia de Desarrollo de Software, se nos ha pedido, a modo de parcial, cumplir la consigna de la entrevista tecnica sobre Magneto.

Magneto necesita un programa que reciba secuencias de ADN (matrices cuadradas con las letras 'ATGC') y determine si es mutante o no.

**Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.** <br/>


## Herramientas

✅ Java <br/>
✅ Spring Boot <br/>
✅ H2 Database <br/>
✅ Render <br/>
✅ Docker <br/>


## Instrucciones

**1)** Para utilizar la aplicación utilizaremos algún programa de peticiones (como Postman) utilizando el deploy obtenido con Render: https://camachotomas-parcial-backend.onrender.com. <br/>

**2)** Agregaremos el path correspondiente a la petición que se quiera hacer: <br/>

   **2.1)** POST: agregar el path '/mutant' acompañado de un Body como el siguiente: <br/>
   
```json
{
    "dna": [
        "AAAA",
        "CCCC",
        "TCAG",
        "GGTC"
    ]
}
```

Se obtendrá la respuesta de si es o no mutante, y se agregará a la base de datos

   **2.2)** GET: agregar el path '/stats'. Se obtendrá la cantidad de mutantes, la cantidad de humanos, y el ratio. <br/>

   



## Otros ejemplos de ADN

**Mutantes**:

```json
{
    "dna": [
        "TGAC",
        "AGCC",
        "TGAC",
        "GGTC"
    ]
}
```


```json
{
    "dna": [
        "TCGGGTGAT",
        "TGATCCTTT",
        "TACGAGTGA",
        "AAATGTACG",
        "ACGAGTGCT",
        "AGACACATG",
        "GAATTCCAA",
        "ACTACGACC",
        "TGAGTATCC"
    ]
}
```


**No Mutantes**:

```json
{
    "dna": [
        "TGAC",
        "ATCC",
        "TAAG",
        "GGTC"
    ]
}
```

```json
{
    "dna": [
        "ATGATG",
        "GTCTTA",
        "AATTGG",
        "ACTAGT",
        "GGATTC",
        "AGGCAA"
    ]
}
```

## Ver la base de datos con H2

Levantar la base de datos con: https://camachotomas-parcial-backend.onrender.com/h2-console/ <br/>

JDBC: jdbc:h2:mem:./testdb


## Pruebas con JMeter y Diagramas de Secuencia
