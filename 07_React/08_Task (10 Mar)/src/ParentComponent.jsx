import React, { useState, useEffect } from 'react';
import axios from 'axios';
import ChildComponent from './ChildComponent';
import './ParentComponent.css';

function ParentComponent() {
    const [data, setData] = useState(null);
    const [number, setNumber] = useState('');
    const [submittedData, setSubmittedData] = useState(null);

    useEffect(() => {
        if (number >= 1 && number <= 100) {
            axios.get(`https://jsonplaceholder.typicode.com/posts/${number}`)
                .then((response) => {
                    setData(response.data);
                })
                .catch((error) => {
                    console.error("There was an error fetching the data!", error);
                });
        }
    }, [number]);

    const handleFormSubmit = (event) => {
        event.preventDefault();
        setSubmittedData(data);
        setNumber('');
    };

    return (
        <div className="container my-4">
            <div className="form-container row">
                <div className="first-half col-md-6">
                    <h3>Form</h3>
                    <form onSubmit={handleFormSubmit} className="form-group">
                        <div className="mb-3">
                            <label htmlFor="formNumber" className="form-label">
                                Enter number (1 to 100) to fetch the data
                            </label>
                            <input
                                type="number"
                                className="form-control"
                                id="formNumber"
                                value={number}
                                onChange={(event) => setNumber(event.target.value)}
                                placeholder="Enter a number"
                                min="1"
                                max="100"
                            />
                        </div>
                        <button type="submit" className="btn btn-primary">
                            Submit
                        </button>
                    </form>
                </div>

                <div className="second-half col-md-6">
                    <div className="child-data">
                        <ChildComponent data={submittedData} />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ParentComponent;
