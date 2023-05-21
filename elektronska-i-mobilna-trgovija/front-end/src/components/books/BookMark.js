import "./../../css/BookMark.css"


import { Link, useLocation, useParams } from "react-router-dom"
import {useNavigate} from "react-router";

import bookstoreRepository from "./../../repository/bookstoreRepository"

const BookMark = () => {
    const navigate = useNavigate()
    const { state } = useLocation()
    const book = Number(useParams()["book"])

    function handleClick() {
        bookstoreRepository.markBook(book).then(() => navigate("/books"))
    }

    return (
        <>
            {state.availableCopies !== 0 ? (
                <div className="mark">
                    <h1>Mark Book</h1>
                    <p>Are you sure you want to mark this book?</p>
                    <button type="button" onClick={handleClick}>
                        Mark
                    </button>
                </div>
            ) : (
                <div className="mark">
                    <h1>Mark Book</h1>
                    <p>There are no available copies of this book.</p>
                    <Link to="/books">Back</Link>
                </div>
            )}
        </>
    )
}
export default BookMark;