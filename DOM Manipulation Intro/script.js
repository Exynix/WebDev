window.onload = () =>{
    /* obtain element by id */
    let body = document.getElementById("body")
    console.log(body.innerHTML);
    document.getElementById("title").innerHTML += "modification by concatenation"

    /* obtain elements with a tag */
    const paragraphArray = document.getElementsByTagName("p")
    let index = 0
    for (p of paragraphArray){
        index++
        p.innerHTML += (" " + index)
    }

    let hyperlinks = ["http://github.com", "https://habitica.com"]
    const element = document.getElementById("linkContainer")
    /* Putting const is a good practice, specially in arrays. It lets arrays modified but NOT reassigned. */
    
    for (link of hyperlinks){
        let tag = "<a href=" + link + "class='links'>" + link + "</a><br>"
        element.innerHTML += tag
    
    }

    for(link of hyperlinks){
        const para = document.createElement("a")
        const node = document.createTextNode(link)
        para.appendChild(node)

        para.href=link
        para.className="links"

        element.appendChild(para)
    }

    document.getElementById("title").style.color = "blue"

    /* Get tags by their class */
    let linksTags = document.getElementsByClassName("links")

    for (let element of linksTags){
        element.style.color = "orange"
    }

    let subtitle = document.getElementById("subtitle")
    subtitle.addEventListener("mouseout", ()=> decreaseFontSize(subtitle))
}

function changeColor(element){
    element.style.color = "red"
}

function increaseFontSize(element){
    element.style.fontSize = "50px"
}

function decreaseFontSize(element){
    element.style.fontSize = "25px"
}