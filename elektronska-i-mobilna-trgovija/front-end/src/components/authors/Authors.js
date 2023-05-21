import React from 'react';

const Authors = ({authors}) => {
    return (
        <div className="container mt-5">
            <div className="row">
                <div className="col">
                    <h1 className="text-center">Authors</h1>
                    <table className="table table-striped">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Country</th>
                        </tr>
                        </thead>
                        <tbody>
                        {authors.map(author => (
                            <tr key={author.id}>
                                <td>{`${author.name}`}</td>
                                <td>{`${author.surname}`}</td>
                                <td>{`${author.country.name}`}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Authors;