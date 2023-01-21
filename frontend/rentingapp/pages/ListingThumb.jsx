import React, { useState, useEffect } from 'react';
import axios from 'axios';
const ListingThumb = () => {
    const [listing, setListing] = useState([]);

    useEffect(() => {
    async function fetchData() {
        const response = await axios.get('/allEquipment');
        setListing(response.data);
    }
    fetchData();
  }, []);

  return (
    <div>
      {listing.map(listing => (
        <ListingThumb
          key={listing.id} 
          name={listing.name} 
          location={listing.location} 
          img={listing.img}
          
        />
      ))}
    </div>
  );
}




export default ListingThumb;