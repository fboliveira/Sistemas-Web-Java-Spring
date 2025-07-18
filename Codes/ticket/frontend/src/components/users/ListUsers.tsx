import { useEffect, useState } from "react"
import { Link } from "react-router-dom"
import api from "../../services/api"
import Card from "../card/Card"

interface UsersInterface {
    id: string,
    name: string,
    email: string
}

const ListUsers = () => {
    
    const [ users, setUsers ] = useState<UsersInterface[]>([])
    
    useEffect(() => {
        api('/api/users')
            .then(response => {
                // console.log(response)
                setUsers(response)
            })
    }, [])

    return (

    <div>
        <div>
            <Link to="/">Voltar</Link>
        </div>        
        <h2>Lista de Usuários</h2>


        <div>
            {
                users.map(user => (
                    <Card key={user.id} id={user.id} description={user.name} />
                ))
            }
        </div>

    </div>

)

}

export default ListUsers