console.log("Script is loading...");

let currentTheme = getTheme();
//initially 
document.addEventListener('DOMContentLoaded',() => {
    changeTheme();
});


function changeTheme() {
    //set to web page
    document.querySelector('html').classList.add(currentTheme);

    //change or toggle the current theme dark to light, light to dark
    //set the lister to change theme
    const chagneThemeButton = document.querySelector('#theme_change_button');
    chagneThemeButton.addEventListener("click", (event) => {
        console.log("change theme button clicked");
        const oldTheme = currentTheme;
        if (currentTheme == "dark") {
            //change it to light
            currentTheme = "light";
        } else {
            currentTheme = "dark";
        }
        //update in local storage also
        setTheme(currentTheme);
        //remove the current theme
        document.querySelector('html').classList.remove(oldTheme);
        //set the current theme 
        document.querySelector('html').classList.add(currentTheme);

        //changing the text of the button also
        chagneThemeButton.querySelector('span').textContent = currentTheme == 'light' ? 'Dark' : 'Light';

    })


}

// set theme to localstorage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

// get theme from localstorage
function getTheme() {
    let theme = localStorage.getItem("theme");
    if (theme) return theme;
    return "light";
}