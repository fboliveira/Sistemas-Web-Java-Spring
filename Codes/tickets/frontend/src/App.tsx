import { Button } from "./components/ui/button"
import ListUsers from "./pages/users/ListUsers"

function App() {

  return (
    <>
      <h1 className="text-3xl font-bold">Sistema de Vendas de Tickets</h1>

      <Button>Login</Button>

      <ListUsers />


    </>
  )
}

export default App
