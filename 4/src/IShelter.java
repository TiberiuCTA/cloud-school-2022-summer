public interface IShelter {
     String getName();
     float getLatitude();
     float getLongitude();
     String getOwner();
     double reciveDonation();

     Pair spend();
}
