import React, { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [pokemonList, setPokemonList] = useState([]);

  useEffect(() => {
    fetchPokemonList();
  }, []);

  const fetchPokemonList = () => {
    fetch('https://pokeapi.co/api/v2/pokemon?limit=807')
      .then((response) => {
        if (!response.ok) {
          throw new Error('');
        }
        return response.json();
      })
      .then((data) => {
        setPokemonList(data.results);
      })
      .catch((err) => {
        console.log('Error fetching Pokemon:', err);
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
