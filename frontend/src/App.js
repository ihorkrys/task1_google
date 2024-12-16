import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}


// function App() {
//     const [message, setMessage] = useState('');
//
//     useEffect(() => {
//         fetch('/api/hello')
//             .then(response => response.text())
//             .then(data => setMessage(data))
//             .catch(error => console.error('Error fetching data:', error));
//     }, []);
//
//     return (
//         <div>
//             <h1>React + Spring Boot + KanBan</h1>
//             <p>{message}</p>
//         </div>
//     );
// }
//
// export default App;


export default App;
