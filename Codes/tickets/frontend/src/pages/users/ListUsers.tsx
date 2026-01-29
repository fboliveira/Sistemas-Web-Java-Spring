import api from "@/services/api"
import type { UserInterface } from "@/types/users"
import { useEffect, useState } from "react"


const ListUsers = () => {

    // Hook: useState
    const [ users, setUsers ] = useState<UserInterface[]>([])

    // Hook: useEffect
    useEffect(() => {

        api.get('/api/users')
            .then(response => {
                console.log(response)
                setUsers(response.data)
            })

    }, [])

    return(
        <>
            <h2>Lista de usuários</h2>

            <ul>

                {
                    users.map( user => (
                        <li key={user.id}>{user.name}</li>
                    ) )
                }

            </ul>
        </>
    )
    
}

export default ListUsers
