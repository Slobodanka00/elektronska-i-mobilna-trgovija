import { Suspense, useEffect, useState } from "react"
import {Routes} from "react-router";
import {Route} from "react-router";

import bookstoreRepository from "./repository/bookstoreRepository"
import Authors from "./components/authors/Authors";
import BookDelete from "./components/books/BookDelete"
import BookForm from "./components/books/BookForm"
import BookMark from "./components/books/BookMark"
import Books from "./components/books/Books"
import Categories from "./components/categories/Categories";
import Header from "./components/header/Header";

const App = () => {
    const [books, setBooks] = useState([])
    const [categories, setCategories] = useState([])
    const [authors, setAuthors] = useState([])

    useEffect(() => {
        bookstoreRepository.getBooks().then(response => setBooks(response.data))
    }, [])

    useEffect(() => {
        bookstoreRepository.getCategories().then(response => setCategories(response.data))
    }, [])

    useEffect(() => {
        bookstoreRepository.getAuthors().then(response => setAuthors(response.data))
    }, [])

    function deleteBook(id) {
        setBooks(books.filter(book => book.id !== id))
    }

    function editBook(book) {
        setBooks(books.map(b => (b.id === book.id ? book : b)))
    }

    return (
        <>
            <Header />
            <Suspense fallback={<div>Loading...</div>}>
                <div className="container">
                    <Routes>
                        <Route path="/" element={<Books />} />
                        <Route path="/books" element={<Books />} />
                        <Route
                            path="/categories"
                            element={<Categories categories={categories} />}
                        />
                        <Route path="/authors" element={<Authors authors={authors} />} />
                        <Route
                            path="/books/add"
                            element={
                                <BookForm
                                    categories={categories}
                                    authors={authors}
                                    editBookFn={editBook}
                                />
                            }
                        />
                        <Route
                            path="/books/edit/:book"
                            element={
                                <BookForm
                                    categories={categories}
                                    authors={authors}
                                    editBookFn={editBook}
                                />
                            }
                        />
                        <Route
                            path="/books/delete/:book"
                            element={<BookDelete updateState={deleteBook} />}
                        />
                        <Route path="/books/mark/:book" element={<BookMark />} />
                    </Routes>
                </div>
            </Suspense>
        </>
    )
}

export default App;
