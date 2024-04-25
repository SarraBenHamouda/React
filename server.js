const express = require("express")

//console.log(express)
const app =express()
//console.log(app)
const PORT =8000
app.use(express.json());
app.use(express.urlencoded({extended:true}));


const pokemon = [
    { id: 1, name: "Bulbasaur" },
    { id: 2, name: "Charmander" },
    { id: 3, name: "Squirtle" },
    { id: 4, name: "Pikachu" },
    { id: 5, name: "Eevee" }
];
//dummmy route
app.get("/api/pokemon", (req,res) => {
    res.json(pokemon);
});


app.listen(PORT, () => {
    console.log(`>>> Server is up and runninh on PORT ${PORT} and is listening for request and responde to`)
})

app.post("/api/pokemon", (req, res) => {
    console.log(req.body);
    pokemon.push(req.body);
    res.json({ status: "ok" });
});



app.get("api/pokemon/:id", (req,res) => {
    console.log(req.params.id);
    res.jdon(pokemon[1]);
})