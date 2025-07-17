const URL = 'http://localhost:8080'

const api = async (endpoint : string, config? : RequestInit | undefined) => {

    console.log(`Endpoint: ${URL}${endpoint}`)
    const result = await fetch(URL + endpoint, config)
    return await result.json()

}

export default api