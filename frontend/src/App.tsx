import {
  // Componentes importados do Router Dom
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
// componentes do react que eu criei
import Listing from 'pages/Listing';
import Form from 'pages/Form';
import Navbar from "components/Navbar";

function App() {
  return (
    // Inicia configuração das rotas e Navbar inicia todas paginas
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Listing />} />
        <Route path="/form">
          <Route path=":movieId" element={<Form />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;