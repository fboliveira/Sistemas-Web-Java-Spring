import { useEffect, useState } from "react"
import api from "../../services/api"

interface UserInterface {
    id: string,
    name: string,
    email: string
}

const ListUsers = () => {
    
    // Hook: useState
    const [ users, setUsers ] = useState<UserInterface[]>([])

    // Hook: useEffect
    useEffect(() =>{

        api('/api/users')
            .then(response => {
                console.log(response)
                setUsers(response)
             })
            .catch(error => console.error(error))

    }, [])

    return(

        <div>
            <h2>Lista de usuários</h2>

            <div>
                {
                    users.map( user => (
                        <div>
                            <p>{user.id}</p>
                            <p>{user.name}</p>
                            <p>{user.email}</p>
                        </div>
                    ) )
                }
            </div>

        </div>


    )
 
}

export default ListUsers