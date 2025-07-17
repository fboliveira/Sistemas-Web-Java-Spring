import { BrowserRouter, Route, Routes } from "react-router-dom"
import App from "../App"
import ListUsers from "../components/users/ListUsers"

const AppRoutes = () => {

    return (
        <>
        
            <BrowserRouter>
            
                <Routes>

                    <Route path="/" element = { <App /> } />
                    <Route path="/users" element = { <ListUsers /> } />

                </Routes>
            
            </BrowserRouter>

        </>
    )

}

export default AppRoutes