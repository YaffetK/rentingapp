import Axios from 'axios'
import { useEffect, useState } from 'react'

const API_URL = 'http://localhost:8080/users'

// Hur man kan hämta data från en API genom ASYNC & AWAIT och sedan använda den i en funktion
// const getData = async () => {
//     const response = await Axios.get(API_URL)
//     const info = response.data.map((data) => allEquipments((data.name)))
//     return info
// }



const EquipmentDefault = () => {

    const [data, setData] = useState([])


    useEffect(() => {
        Axios.get(API_URL).then(res => {
            setData(res.data)
        }).catch(
            err => console.log(err)
        )
    }, []);



    return (
        <main className='min-h-screen'>
            <div className='flex border-8 m-8'>
                {data.map(item => (
                    <div key={item.id}>
                        <h2>{item.name}</h2>
                        <h2> {item.last_name}</h2>
                        <p>{item.email}</p>
                    </div>

                ))}
            </div>



        </main>

    )
}
export default EquipmentDefault