import axios from "../custom-axios/axios";

const bookstoreRepository = {
    getBooks: () => {
        return axios.get("/books/list");
    },
    getCategories: () => {
        return axios.get("/categories/list");
    },
    getAuthors: () => {
        return axios.get("/authors/list");
    },
    getBooksByPage: (page) => {
        return axios.get(`/books/list/page/${page}`);
    },
    getBookById: (id) => {
        return axios.get(`/books/${id}`);
    },
    addBook: (name, category, author, availableCopies) => {
        return axios.post("/books/add", {
            "name": name,
            "category": category,
            "author": author,
            "availableCopies": availableCopies
        });
    },
    editBook: (id, name, category, author, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name": name,
            "category": category,
            "author": author,
            "availableCopies": availableCopies
        });
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    markBook: (id) => {
        return axios.put(`/books/mark/${id}`);
    }
};

export default bookstoreRepository;