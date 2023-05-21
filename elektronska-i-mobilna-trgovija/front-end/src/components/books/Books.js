import "./../../css/Books.css"

import { useEffect, useState } from "react"

import bookstoreRepository from "./../../repository/bookstoreRepository"
import Book from "./Book";

const Books = () => {
    const [books, setBooks] = useState([])
    const [page, setPage] = useState(0)
    const [pages, setPages] = useState(0)

    useEffect(() => {
        bookstoreRepository.getBooksByPage(page).then(response => {
            if (response.data !== 0) {
                setBooks(response.data)
            }
        })
    }, [page])

    useEffect(() => {
        bookstoreRepository.getBooks().then(response => {
            if (response.data !== 0) {
                setPages(Math.ceil(response.data.length / 5))
            }
        })
    }, [])

    function handlePrevious() {
        if (page > 0) {
            setPage(page - 1)
        }
    }

    function handleNext() {
        if (page < pages - 1) {
            setPage(page + 1)
        }
    }

    return (
        <div className="books">
            <h1 id="booksTitle">Books</h1>
            <ul>
                {books.map(book => (
                    <li key={book.id}>
                        <Book book={book} category={book.category}/>
                    </li>
                ))}
            </ul>
            <button id="pageButtons" type="button" onClick={handlePrevious}>
                previous️
            </button>
            <span className="page-number">
        {page + 1} / {pages}
      </span>
            <button id="pageButtons" type="button" onClick={handleNext}>
                next️
            </button>
        </div>
    )
}
export default Books;
