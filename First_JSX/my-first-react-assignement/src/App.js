
import './App.css';

function App() {
  console.log("hello")
  const message = "Hello"
  const things = ['Learn React' , 'Climb Mt.Everest' , 'Run a marathon' , 'Feed the dogs']
  return (
    <fieldset className="App">
      <legend>App.js</legend>
     <h1>{message} Dojo !</h1>
     <h2>Things i need to do :</h2>
    <ol>
      {
        things.map((eachThings) => {
          return <li>{eachThings}</li>
        })
      }
    </ol>


    </fieldset>
  );
}

export default App;
