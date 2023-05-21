import "./../../css/BookDelete.css"

import {useParams} from "react-router-dom";

import bookstoreRepository from "./../../repository/bookstoreRepository"
import {useNavigate} from "react-router";

const BookDelete =({ updateState }) => {
    const navigate = useNavigate()
    const book = Number(useParams()["book"])

    function handleClick() {
        bookstoreRepository.deleteBook(book).then(() => {
            updateState(book)
            navigate("/")
        })
    }

    return (
        <div className="delete">
            <h1>Delete Book</h1>
            <p>Are you sure you want to delete this book?</p>
            <button type="button" onClick={handleClick}>
                Delete
            </button>
        </div>
    )
}

export default BookDelete;