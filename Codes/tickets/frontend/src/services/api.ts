import axios from "axios"

const SERVER = 'http://localhost:8080'

const api = axios.create({
    baseURL: SERVER
})

const api_fetch = async (endpoint: string,
    config?: RequestInit
) => {

    const result = await fetch(SERVER + endpoint, config)
    return await result.json()

}

export default api
export { api_fetch }