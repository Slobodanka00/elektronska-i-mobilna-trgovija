import "./../../css/Header.css";

import { Link } from "react-router-dom";
import { Navbar, Container, Nav } from "react-bootstrap";

const Header = () => {
    return (
        <header>
            <Navbar bg="light" expand="lg">
                <Container>
                    <Navbar.Brand href="#home" className="mx-auto">
                        Book Store
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="mx-auto">
                            <Nav.Link as={Link} to="/books" className="nav-link">
                                Books
                            </Nav.Link>
                            <Nav.Link as={Link} to="/categories" className="nav-link">
                                Categories
                            </Nav.Link>
                            <Nav.Link as={Link} to="/authors" className="nav-link">
                                Authors
                            </Nav.Link>
                            <Nav.Link as={Link} to="/books/add" className="btn btn-primary">
                                Add Book
                            </Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </header>
    );
};

export default Header;