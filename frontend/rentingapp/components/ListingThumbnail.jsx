import React, { useEffect, useState } from "react";
import axios from "axios";

const ListingThumbnail = ({ name,location, img}) => {
  return (
    <div>
      <h2>{name}</h2>
      <p>Location: {location}</p>
      <p>Brand: {img}</p>
    </div>
  );
};
