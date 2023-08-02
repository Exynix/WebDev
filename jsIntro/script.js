console.log("hello world")

/* variables */
let variable = 5
console.log(variable)
variable = "Numero 5"
console.log(variable)

/* condicionales */
let x = 11
if(x > 10){
    console.log(x + " es mayor que 10")
} else {
    console.log(x + " no es mayo que 10")
}

/* Ciclos */
for (let i = 0; i<10; i++){
    console.log(i)
}

let i = 0
while(i < 10){
    console.log(i)
    i++
}

/* Arrays */
/* They are dinamic, and different types of data can be put in the same array */
let arreglo = [1, 2, 3, 4]
console.log("arreglo " + arreglo);
let arregloMixto = [1, "Manzana", 2, "pera", 3.1]
console.log("Arreglo Mixto " + arregloMixto);
console.log("Item 3 of mixed array " + arregloMixto[3]);
console.log("Length of mixed array " + arregloMixto.length);
console.log("strings of mixed array " + arregloMixto.toString());
console.log("joining elements " + arregloMixto.join("-"));

/* Manipulation of arrays */
let pares = [1, 3, 5]
let impares = [2, 4, 6]

let mixedNumbers = pares.concat(impares)
console.log("All numbers" + mixedNumbers)
mixedNumbers.push(79)
console.log("All numbers" + mixedNumbers)
mixedNumbers.pop()
console.log("All numbers" + mixedNumbers)
let result = mixedNumbers.slice(2,5)
console.log(result);

/* Iteration of arrays */
for(let object of mixedNumbers){ /* Prints index of item */
    console.log(object)
}

for (let object in mixedNumbers){ /* Prints content of item */
    console.log(object)
}

/* Functions */
function sum (num1, num2){
    return num1 + num2
}

function multiply (num1, num2){
    num1*num2
}

console.log("Result" + sum(4,5))

/* Functions as parameters */
function mathOperation(num1, num2, operation){
    return operation(num1, num2)

}

console.log("multiply" + mathOperation(4,7,multiply))

/* anonimous functions */
let anonimousResult = mathOperation(4, 7, function(x,y) {return x*y})
/* to complement. i have a photo of it */

let var1 = 3
let var2 = "3"

if (var1 == var2){ /* Evaluates to true. js ultimately interpretes all data type to the same */
    console.log("Iguales");
} else {
    console.log("Different");
}

/* The solution is the triple equal */
/*if (var1 === var2) */


/* JSON */
let person = {
    name: "juan",
    surname: "angarita",
    edad:16,
    pet: {
        breed: "golden"
    }
}
console.log(person);
console.log(person.name)
console.log(person["name"])

for(let data of Object.entries(person)){
    console.log(data);
}

let literals = `El resultado de la suma es ${2 + 3} `
console.log(literals)