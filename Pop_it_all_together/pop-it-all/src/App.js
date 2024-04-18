
import './App.css';
import newfile from './components/newfile';
var personArr =[
  {"firstName":"Jane", "lastName":"Doe", "age":45, "hairColor":"Black"},
  {"firstName":"John", "lastName":"Smith","age":88,"hairColor":"Brown"},
  {"firstName":"Millard", "lastName":"Fillmore","age":50,"hairColor":"Brown"},
  {"firstName":"Maria", "lastName":"Smith","age":62,"hairColor":"Brown"}
]

const handleBirthday = () => {
  setAge(age + 1);
};

function App() {
  return (
    <div className="App">
    {personArr.map(person => {
        return <newfile firstName={person.firstName} lastName={person.lastName} age={person.age} hairColor={person.hairColor} />
      })
      
      }

<div>
      <h1>Birthday Celebration</h1>
      <button onClick={handleBirthday}>Celebrate Birthday</button>
    </div>
    </div>
  );
}

export default App;
