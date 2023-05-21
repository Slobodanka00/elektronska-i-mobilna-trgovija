import "./../../css/Book.css"

import { Link } from "react-router-dom"

const Book = ({ book }) => {
    return (
        <div className="book">
            <h2>{book.name}</h2>
            <p>Category: {book.category}</p>
            <p>
                Author: {book.author.name} {book.author.surname}
            </p>
            <p>Available Copies: {book.availableCopies}</p>
            <p id="options">Options:</p>
            <Link to={`/books/edit/${book.id}`}>Edit</Link>
            <Link to={`/books/delete/${book.id}`}>Delete</Link>
            <Link
                to={`/books/mark/${book.id}`}
                state={{ availableCopies: book.availableCopies }}
            >
                Mark
            </Link>
        </div>
    )
}
export default Book;