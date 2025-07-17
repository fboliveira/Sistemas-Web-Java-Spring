import { Link } from "react-router-dom"

const Menu = () => {

    return(

        <>
            <h2>Menu</h2>
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/users">Usuários</Link></li>
                <li><Link to="#">Vendas</Link></li>
            </ul>
        </>

    )

    
}

export default Menu