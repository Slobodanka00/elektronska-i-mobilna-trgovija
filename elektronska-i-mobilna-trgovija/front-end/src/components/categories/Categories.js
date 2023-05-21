import React from 'react';

const Categories = ({categories}) => {
    return (
        <div className="container mt-5">
            <div className="row">
                <div className="col">
                    <h1 className="text-center">Categories</h1>
                    <table className="table table-striped">
                        <thead>
                        <tr>
                            <th>Name</th>

                        </tr>
                        </thead>
                        <tbody>
                        {categories.map(category => (
                            <tr key={category}>
                                <td>{category}</td>
                                <td></td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Categories;