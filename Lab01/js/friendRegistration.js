const friendRegistrationForm = document.getElementById("friendRegistrationForm")
const friendUsername = document.getElementById("username")
const friendName = document.getElementById("name")
const friendImage = document.getElementById("image")
const friendPet = document.getElementById("pet")
const pageContent = document.getElementById("pageContent")

const outputTable = document.getElementById("friendsTable")

const friendsMap = new Map()

friendRegistrationForm.addEventListener("submit", (E) =>{

    E.preventDefault()

    // If the friend is not registered, it is added to the map. The friend is also added to the table.
    if(!friendsMap.has(friendUsername.value)){
        friendsMap.set(friendUsername.value, saveFriendToJSON(friendName.value, friendImage.value, friendPet.value))
        let newTableRow = 
            "<tr>" 
            +    "<td>" + friendUsername.value + "</td>"
            +    "<td>" + friendName.value + "</td>"
            +    "<td>"+ friendImage.value + "</td>"
            +    "<td>"+ "<button type='button' onClick='showPets(" + friendUsername.value + ")'>See Pets</button>" + "</td>"
            + "</tr>" 
         
        outputTable.innerHTML += newTableRow
    }else{ 
        // If friend is registered, then the pet is added to their pets array.    
        friendsMap[friendUsername.value].push(friendPet.value)
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

function showPets(username){
    let newH2 = "<h2>" + username + "'s pets" + "</h2>"
    pageContent.innerHTML += newH2

    let petsListStart = "<ul>"
    pageContent.innerHtml += petsListStart

    const userPets = friendsMap[username].pets

    for(pet of userPets){
        let petsListItem = "<li>" + pet + "</li>"
    }

    let petsListEnd = "</ul>"

}