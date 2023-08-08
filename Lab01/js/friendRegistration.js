const friendRegistrationForm = document.getElementById("friendRegistrationForm")
const friendUsername = document.getElementById("username")
const friendName = document.getElementById("name")
const friendImage = document.getElementById("image")
const friendPet = document.getElementById("pet")
const pageContent = document.getElementById("pageContent")
const outputTable = document.getElementById("friendsTable")

const friendsMap = new Map()

// Load previous values onto the input fields
const storedUsername = localStorage.getItem('inputUsername')
const storedName = localStorage.getItem('inputName')
const storedImage = localStorage.getItem('inputImage')
const storedPet = localStorage.getItem('inputPet')

if (storedUsername){
    friendUsername.value = storedUsername
}

if (storedName){
    friendName.value = storedName
}

if (storedImage){
    friendImage.value = storedImage
}

if (storedPet){
    friendPet.value = storedPet
}

friendRegistrationForm.addEventListener("submit", (E) =>{

    E.preventDefault() // to avoid the page from refreshing.

    // Save values locally
    localStorage.setItem('inputUsername', friendUsername.value)
    localStorage.setItem('inputName', friendName.value)
    localStorage.setItem('inputImage', friendImage.value)
    localStorage.setItem('inputPet', friendPet.value)

    // If the friend is not registered, it is added to the map. The friend is also added to the table.
    if(!friendsMap.has(friendUsername.value)){
        friendsMap.set(friendUsername.value, saveFriendToJSON(friendName.value, friendImage.value, friendPet.value))
        let newTableRow = createTableRow(friendUsername.value, friendName.value, friendImage.value)
        outputTable.innerHTML += newTableRow

        const showPetsButton = document.getElementsByName(friendUsername.value)
        showPetsButton[0].addEventListener("click",  (E) => {

            E.preventDefault()
            showPets(friendUsername.value)
        })
    }else{ 
        // If friend is registered, then the pet is added to their pets array.    
        // friendsMap[friendUsername.value].push(friendPet.value)
        friendsMap.get(friendUsername.value).pets.push(friendPet.value)
        console.log(friendsMap.get(friendUsername.value).pets);
    }
})



// Username is not saved because it's used as the key in the friends map.
function saveFriendToJSON(name, image, pet){
    let friend = {
        name: name,
        image: image,
        pets: [pet]
    }
    return friend
}

function createTableRow(username, name, image){

    let stringTableRowHtml = 
        "<tr>" 
        +    "<td>" + username + "</td>"
        +    "<td>" + name + "</td>"
        +    "<td>" + image + "</td>"
        +    "<td>" + "<button type='submit' class='petsButton' name='" + username +  "'>See Pets</button>" + "</td>"
        + "</tr>" 

        return stringTableRowHtml

/*
        const newRow = outputTable.insertRow()
        const cell1 = newRow.insertCell(0)
        const cell2 = newRow.insertCell(1)
        const cell3 = newRow.insertCell(2)
        const cell4 = newRow.insertCell(3)

        cell1.textContent = username
        cell2.textContent = name
        cell3.textContent = image

        const showPetsButton = document.createElement('button')
        showPetsButton.textContent = 'Show pets'
        showPetsButton.addEventListener('click', showPets(username))

        cell4.appendChild(showPetsButton)

*/
    
}

function showPets(username){
 
    let newH2 = "<h2>" + username + "'s pets" + "</h2>"
    pageContent.innerHTML += newH2

    let petsListStart = "<ul>"
    pageContent.innerHtml += petsListStart

    const userPets = friendsMap.get(username).pets


    for(pet of userPets){
        let petsListItem = "<li>" + pet + "</li>"
        pageContent.innerHTML += petsListItem
    }

    let petsListEnd = "</ul>"
    pageContent.innerHTML += petsListEnd

}

function storeValuesLocally(username, name, image, pet){


}