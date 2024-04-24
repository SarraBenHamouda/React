import React, { useState, useEffect } from 'react';
import './App.css';
import axios from 'axios';

function App() {
  const [pokemonList, setPokemonList] = useState([]);

  useEffect(() => {
    
    fetchPokemonList();
  }, []);

  const fetchPokemonList = () => {
    axios
      .get('https://pokeapi.co/api/v2/pokemon?limit=807')
      .then((response) => {
        setPokemonList(response.data);
      })
      .catch((err) => {
        console.log( err);
      });
  };

  return (
    <div className="App">
      <h1>Pokemon API</h1>
      <button onClick={fetchPokemonList}>Fetch Pokemon</button>
      <table>
        <thead>
          <tr>
            <th>Name</th>
          </tr>
        </thead>
        <tbody>
          {pokemonList.map((pokemon, i) => (
            <tr key={i}>
              <td>{pokemon.name}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
