import bg.sofia.uni.fmi.mjt.cooking.javaclient.JavaClient;

import java.io.IOException;

public class Main {
   /* List<String> validDietTypes = new ArrayList<>() {
        {
            add("alcohol-cocktail");
            add("alcohol-free");
            add("celery-free");
            add("crustacean-free");
            add("dairy-free");
            add("egg-free");
            add("fish-free");
            add("fodmap-free");
            add("gluten-free");
            add("immuno-supportive");
            add("keto-friendly");
            add("kidney-friendly");
            add("kosher");
            add("low-sugar");
            add("low-potassium");
            add("lupine-free");
            add("Mediterranean");
            add("mollusk-free");
            add("mustard-free");
            add("No-oil-added");
            add("paleo");
            add("peanut-free");
            add("pescatarian");
            add("pork-free");
            add("red-meat-free");
            add("sesame-free");
            add("shellfish-free");
            add("soy-free");
            add("sugar-conscious");
            add("sulfate-free");
            add("tree-nut-free");
            add("vegan");
            add("vegetarian");
            add("wheat-free");

/* alcohol-cocktail   alcohol-free  celery-free  crustacean-free  dairy-free  DASH  egg-free
fish-free  fodmap-free   gluten-free  immuno-supportive  keto-friendly  kidney-friendly  kosher
 low-potassium  low-sugar  lupine-free  Mediterranean  mollusk-free  mustard-free  No-oil-added
  paleo  peanut-free  pecatarian  pork-free  red-meat-free  sesame-free  shellfish-free  soy-free
   sugar-conscious  sulfite-free  tree-nut-free  vegan  vegetarian wheat-free

        }
    };*/

    public static void main(String[] args) {
/*
//        HttpClient client = HttpClient.newBuilder().build();

        /*String health = "wheat-free";
        String type = "Dinner";

        String appId = "77f6f16b";
        String appKey = "935af6a49a4bb529045fc619845bb7b3";
//        JavaClient j1 = new JavaClient();

       Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the diet types you want to search for: ");
        String dietTypes = s1.nextLine();

        System.out.println("Enter the meal types you want to search for: ");

        System.out.println(dietType);

        // Build the URI with user input and API credentials
        URI uri = URI.create("https://api.edamam.com/api/recipes/v2?type=public&app_id=" + appId + "&app_key=" + appKey
            + dietType + "&mealType=" + type);


        // Create HttpClient
//       / HttpClient httpClient = HttpClient.newHttpClient();

        // Create HttpRequest
//        HttpRequest request = HttpRequest.newBuilder()
//            .uri(j1.initURI())
//            .header("Accept", "application/json")
//            .header("Accept-Language", "en")
//            .build();
//
//        System.out.println(uri.toString());
*/
/*String jsonString2 = "{\n" +
    "    \"uri\": \"http://www.edamam.com/ontologies/edamam.owl#recipe_e4f821c4563a12e2a9ee24ba48ae2c4e\",\n" +
    "    \"label\": \"Quick Zucchini Sauté\",\n" +
    "    \"image\": \"https://edamam-product-images.s3.amazonaws.com/web-img/0da/0dabaefd9468383321193114f89f9a63.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjENP%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIAg7XcZUVz0Y06Cqe8sAO2m0kfNdXpMpXxMqhgyUjKIdAiB6CPVlBNVZESjf%2FmPpSBjx1lRbWelPdLeLF%2FOrGq7oQyq5BQh8EAAaDDE4NzAxNzE1MDk4NiIMBvlZalNuorPeFfxeKpYFp%2FyFN2jXx3nSbQvpijlty%2BERdGFObxrtQrFZM3DvGiehLmkOMYDgZZvdruRhC2y3UYl0BROvdcn48K6Is3t9xqXwkmGy9odNUH4WZtRcDhCtNEUvyTr%2BD5STtNG1YJCPmvyN3o%2Fa63A4iivqKZPfSuo1WU5yZOoc4fAYwzIyGrenUdXL2xe8DsIQhXgUPYfb8M%2FajMNftOP37jjgg%2BFNMbIhPjsTzmKY0Drmt7E0jGO6iuSvnagJNjfQXd%2Bur6cFV5dxcOx2JC5zULjChOP%2BCHdrsW22q42NJ%2BBu44Pp3bM2do%2BISk%2BVfYeHgrBLgfk2UcXAwg%2BzTMxMVvfrsyQE94GuFkWNgNRMzVwSUHAdMiDm6D2IKNWZSrjqUhzNAT8MJephe27S4D45afvcleBp9IdY58zAWbOjXFB59kNMYbqXIVJov9lNcMee9FCzavAarU9ywzs9k8%2FadSLTIviNwvyY03jXqX2CDYaT1mGxnQyGT1SVzsVIhjspz0PyCALB6zOl4Tvc5Aac380ZwBk61RZuGz2iAP29lwJqYDc81TlB3CCKW7L7ybqj50M6ONSgbHy9HTLaSbP3Uww6NzeGuSHR8CLLfQpcXaM343XSi4RwHswJP%2B8loxp01NB9THrwuB6Am%2F7B77ZhFyur59NdHO4y8jIwivUaeaFTPDtT3zfPehvjBLbvSdfu3UaxrCF6szzzR98HPHTWqfyHfZUndAunzweLF%2Bobm1OqKwORepJytTS9PobDI%2FwdmOxuWguzxMSpFK9IUI4yBy6xEMceOzmAME5Fa6%2FjZ7R0scYTqRwc%2Bz7i8xf7BSpZFnrCDzJiU3FfjaCEELhu3AGERbWDCdhH5MCuqiJRp5BhOSnyXCDX6a33nCAwldqQrQY6sgF9sorIrFW0dr5jovFQRQGsvv9bTYSCgixvlN3zbIRP5ZO5lJzaFm5KNbMfsogoc7KWKeq%2FDDJGqY41uyTx59ICbKDNlQMEoLh%2BRC8RoDtqtooTae09whVh3DredEYzFemya1gYpcX1dEtjdKaukuqv3ns4ZMgbkVR%2BaWKgUwcNEFMyiU%2F2Htf4ItzoMGSRhebBs%2FWF9GiM%2FkgjmNxnGbPBhjKLmGMdDyjAqDp0GzmiOb8T&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20240114T190057Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFH4WBDDOE%2F20240114%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=f778d328d7212c121676d149876fd64ac6f87bc7543b479f7dabf194fbf2e92c\",\n" +
    "    \"images\": {\n" +
    "      \"THUMBNAIL\": {\n" +
    "        \"url\": \"https://edamam-product-images.s3.amazonaws.com/web-img/0da/0dabaefd9468383321193114f89f9a63-s.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjENP%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIAg7XcZUVz0Y06Cqe8sAO2m0kfNdXpMpXxMqhgyUjKIdAiB6CPVlBNVZESjf%2FmPpSBjx1lRbWelPdLeLF%2FOrGq7oQyq5BQh8EAAaDDE4NzAxNzE1MDk4NiIMBvlZalNuorPeFfxeKpYFp%2FyFN2jXx3nSbQvpijlty%2BERdGFObxrtQrFZM3DvGiehLmkOMYDgZZvdruRhC2y3UYl0BROvdcn48K6Is3t9xqXwkmGy9odNUH4WZtRcDhCtNEUvyTr%2BD5STtNG1YJCPmvyN3o%2Fa63A4iivqKZPfSuo1WU5yZOoc4fAYwzIyGrenUdXL2xe8DsIQhXgUPYfb8M%2FajMNftOP37jjgg%2BFNMbIhPjsTzmKY0Drmt7E0jGO6iuSvnagJNjfQXd%2Bur6cFV5dxcOx2JC5zULjChOP%2BCHdrsW22q42NJ%2BBu44Pp3bM2do%2BISk%2BVfYeHgrBLgfk2UcXAwg%2BzTMxMVvfrsyQE94GuFkWNgNRMzVwSUHAdMiDm6D2IKNWZSrjqUhzNAT8MJephe27S4D45afvcleBp9IdY58zAWbOjXFB59kNMYbqXIVJov9lNcMee9FCzavAarU9ywzs9k8%2FadSLTIviNwvyY03jXqX2CDYaT1mGxnQyGT1SVzsVIhjspz0PyCALB6zOl4Tvc5Aac380ZwBk61RZuGz2iAP29lwJqYDc81TlB3CCKW7L7ybqj50M6ONSgbHy9HTLaSbP3Uww6NzeGuSHR8CLLfQpcXaM343XSi4RwHswJP%2B8loxp01NB9THrwuB6Am%2F7B77ZhFyur59NdHO4y8jIwivUaeaFTPDtT3zfPehvjBLbvSdfu3UaxrCF6szzzR98HPHTWqfyHfZUndAunzweLF%2Bobm1OqKwORepJytTS9PobDI%2FwdmOxuWguzxMSpFK9IUI4yBy6xEMceOzmAME5Fa6%2FjZ7R0scYTqRwc%2Bz7i8xf7BSpZFnrCDzJiU3FfjaCEELhu3AGERbWDCdhH5MCuqiJRp5BhOSnyXCDX6a33nCAwldqQrQY6sgF9sorIrFW0dr5jovFQRQGsvv9bTYSCgixvlN3zbIRP5ZO5lJzaFm5KNbMfsogoc7KWKeq%2FDDJGqY41uyTx59ICbKDNlQMEoLh%2BRC8RoDtqtooTae09whVh3DredEYzFemya1gYpcX1dEtjdKaukuqv3ns4ZMgbkVR%2BaWKgUwcNEFMyiU%2F2Htf4ItzoMGSRhebBs%2FWF9GiM%2FkgjmNxnGbPBhjKLmGMdDyjAqDp0GzmiOb8T&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20240114T190057Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFH4WBDDOE%2F20240114%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=def4d80a5db9dd8b56f201ff2ec88bf6f1825c666820ad1b0344726ea4687b5b\",\n" +
    "        \"width\": 100,\n" +
    "        \"height\": 100\n" +
    "      },\n" +
    "      \"SMALL\": {\n" +
    "        \"url\": \"https://edamam-product-images.s3.amazonaws.com/web-img/0da/0dabaefd9468383321193114f89f9a63-m.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjENP%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIAg7XcZUVz0Y06Cqe8sAO2m0kfNdXpMpXxMqhgyUjKIdAiB6CPVlBNVZESjf%2FmPpSBjx1lRbWelPdLeLF%2FOrGq7oQyq5BQh8EAAaDDE4NzAxNzE1MDk4NiIMBvlZalNuorPeFfxeKpYFp%2FyFN2jXx3nSbQvpijlty%2BERdGFObxrtQrFZM3DvGiehLmkOMYDgZZvdruRhC2y3UYl0BROvdcn48K6Is3t9xqXwkmGy9odNUH4WZtRcDhCtNEUvyTr%2BD5STtNG1YJCPmvyN3o%2Fa63A4iivqKZPfSuo1WU5yZOoc4fAYwzIyGrenUdXL2xe8DsIQhXgUPYfb8M%2FajMNftOP37jjgg%2BFNMbIhPjsTzmKY0Drmt7E0jGO6iuSvnagJNjfQXd%2Bur6cFV5dxcOx2JC5zULjChOP%2BCHdrsW22q42NJ%2BBu44Pp3bM2do%2BISk%2BVfYeHgrBLgfk2UcXAwg%2BzTMxMVvfrsyQE94GuFkWNgNRMzVwSUHAdMiDm6D2IKNWZSrjqUhzNAT8MJephe27S4D45afvcleBp9IdY58zAWbOjXFB59kNMYbqXIVJov9lNcMee9FCzavAarU9ywzs9k8%2FadSLTIviNwvyY03jXqX2CDYaT1mGxnQyGT1SVzsVIhjspz0PyCALB6zOl4Tvc5Aac380ZwBk61RZuGz2iAP29lwJqYDc81TlB3CCKW7L7ybqj50M6ONSgbHy9HTLaSbP3Uww6NzeGuSHR8CLLfQpcXaM343XSi4RwHswJP%2B8loxp01NB9THrwuB6Am%2F7B77ZhFyur59NdHO4y8jIwivUaeaFTPDtT3zfPehvjBLbvSdfu3UaxrCF6szzzR98HPHTWqfyHfZUndAunzweLF%2Bobm1OqKwORepJytTS9PobDI%2FwdmOxuWguzxMSpFK9IUI4yBy6xEMceOzmAME5Fa6%2FjZ7R0scYTqRwc%2Bz7i8xf7BSpZFnrCDzJiU3FfjaCEELhu3AGERbWDCdhH5MCuqiJRp5BhOSnyXCDX6a33nCAwldqQrQY6sgF9sorIrFW0dr5jovFQRQGsvv9bTYSCgixvlN3zbIRP5ZO5lJzaFm5KNbMfsogoc7KWKeq%2FDDJGqY41uyTx59ICbKDNlQMEoLh%2BRC8RoDtqtooTae09whVh3DredEYzFemya1gYpcX1dEtjdKaukuqv3ns4ZMgbkVR%2BaWKgUwcNEFMyiU%2F2Htf4ItzoMGSRhebBs%2FWF9GiM%2FkgjmNxnGbPBhjKLmGMdDyjAqDp0GzmiOb8T&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20240114T190057Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFH4WBDDOE%2F20240114%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=d0d7ad4454cca3fb7b4d03a6f5950beb17b0a95da63fbfd3debb300e7d01b8b3\",\n" +
    "        \"width\": 200,\n" +
    "        \"height\": 200\n" +
    "      },\n" +
    "      \"REGULAR\": {\n" +
    "        \"url\": \"https://edamam-product-images.s3.amazonaws.com/web-img/0da/0dabaefd9468383321193114f89f9a63.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjENP%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIAg7XcZUVz0Y06Cqe8sAO2m0kfNdXpMpXxMqhgyUjKIdAiB6CPVlBNVZESjf%2FmPpSBjx1lRbWelPdLeLF%2FOrGq7oQyq5BQh8EAAaDDE4NzAxNzE1MDk4NiIMBvlZalNuorPeFfxeKpYFp%2FyFN2jXx3nSbQvpijlty%2BERdGFObxrtQrFZM3DvGiehLmkOMYDgZZvdruRhC2y3UYl0BROvdcn48K6Is3t9xqXwkmGy9odNUH4WZtRcDhCtNEUvyTr%2BD5STtNG1YJCPmvyN3o%2Fa63A4iivqKZPfSuo1WU5yZOoc4fAYwzIyGrenUdXL2xe8DsIQhXgUPYfb8M%2FajMNftOP37jjgg%2BFNMbIhPjsTzmKY0Drmt7E0jGO6iuSvnagJNjfQXd%2Bur6cFV5dxcOx2JC5zULjChOP%2BCHdrsW22q42NJ%2BBu44Pp3bM2do%2BISk%2BVfYeHgrBLgfk2UcXAwg%2BzTMxMVvfrsyQE94GuFkWNgNRMzVwSUHAdMiDm6D2IKNWZSrjqUhzNAT8MJephe27S4D45afvcleBp9IdY58zAWbOjXFB59kNMYbqXIVJov9lNcMee9FCzavAarU9ywzs9k8%2FadSLTIviNwvyY03jXqX2CDYaT1mGxnQyGT1SVzsVIhjspz0PyCALB6zOl4Tvc5Aac380ZwBk61RZuGz2iAP29lwJqYDc81TlB3CCKW7L7ybqj50M6ONSgbHy9HTLaSbP3Uww6NzeGuSHR8CLLfQpcXaM343XSi4RwHswJP%2B8loxp01NB9THrwuB6Am%2F7B77ZhFyur59NdHO4y8jIwivUaeaFTPDtT3zfPehvjBLbvSdfu3UaxrCF6szzzR98HPHTWqfyHfZUndAunzweLF%2Bobm1OqKwORepJytTS9PobDI%2FwdmOxuWguzxMSpFK9IUI4yBy6xEMceOzmAME5Fa6%2FjZ7R0scYTqRwc%2Bz7i8xf7BSpZFnrCDzJiU3FfjaCEELhu3AGERbWDCdhH5MCuqiJRp5BhOSnyXCDX6a33nCAwldqQrQY6sgF9sorIrFW0dr5jovFQRQGsvv9bTYSCgixvlN3zbIRP5ZO5lJzaFm5KNbMfsogoc7KWKeq%2FDDJGqY41uyTx59ICbKDNlQMEoLh%2BRC8RoDtqtooTae09whVh3DredEYzFemya1gYpcX1dEtjdKaukuqv3ns4ZMgbkVR%2BaWKgUwcNEFMyiU%2F2Htf4ItzoMGSRhebBs%2FWF9GiM%2FkgjmNxnGbPBhjKLmGMdDyjAqDp0GzmiOb8T&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20240114T190057Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFH4WBDDOE%2F20240114%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=f778d328d7212c121676d149876fd64ac6f87bc7543b479f7dabf194fbf2e92c\",\n" +
    "        \"width\": 300,\n" +
    "        \"height\": 300\n" +
    "      },\n" +
    "      \"LARGE\": {\n" +
    "        \"url\": \"https://edamam-product-images.s3.amazonaws.com/web-img/0da/0dabaefd9468383321193114f89f9a63-l.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjENP%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIAg7XcZUVz0Y06Cqe8sAO2m0kfNdXpMpXxMqhgyUjKIdAiB6CPVlBNVZESjf%2FmPpSBjx1lRbWelPdLeLF%2FOrGq7oQyq5BQh8EAAaDDE4NzAxNzE1MDk4NiIMBvlZalNuorPeFfxeKpYFp%2FyFN2jXx3nSbQvpijlty%2BERdGFObxrtQrFZM3DvGiehLmkOMYDgZZvdruRhC2y3UYl0BROvdcn48K6Is3t9xqXwkmGy9odNUH4WZtRcDhCtNEUvyTr%2BD5STtNG1YJCPmvyN3o%2Fa63A4iivqKZPfSuo1WU5yZOoc4fAYwzIyGrenUdXL2xe8DsIQhXgUPYfb8M%2FajMNftOP37jjgg%2BFNMbIhPjsTzmKY0Drmt7E0jGO6iuSvnagJNjfQXd%2Bur6cFV5dxcOx2JC5zULjChOP%2BCHdrsW22q42NJ%2BBu44Pp3bM2do%2BISk%2BVfYeHgrBLgfk2UcXAwg%2BzTMxMVvfrsyQE94GuFkWNgNRMzVwSUHAdMiDm6D2IKNWZSrjqUhzNAT8MJephe27S4D45afvcleBp9IdY58zAWbOjXFB59kNMYbqXIVJov9lNcMee9FCzavAarU9ywzs9k8%2FadSLTIviNwvyY03jXqX2CDYaT1mGxnQyGT1SVzsVIhjspz0PyCALB6zOl4Tvc5Aac380ZwBk61RZuGz2iAP29lwJqYDc81TlB3CCKW7L7ybqj50M6ONSgbHy9HTLaSbP3Uww6NzeGuSHR8CLLfQpcXaM343XSi4RwHswJP%2B8loxp01NB9THrwuB6Am%2F7B77ZhFyur59NdHO4y8jIwivUaeaFTPDtT3zfPehvjBLbvSdfu3UaxrCF6szzzR98HPHTWqfyHfZUndAunzweLF%2Bobm1OqKwORepJytTS9PobDI%2FwdmOxuWguzxMSpFK9IUI4yBy6xEMceOzmAME5Fa6%2FjZ7R0scYTqRwc%2Bz7i8xf7BSpZFnrCDzJiU3FfjaCEELhu3AGERbWDCdhH5MCuqiJRp5BhOSnyXCDX6a33nCAwldqQrQY6sgF9sorIrFW0dr5jovFQRQGsvv9bTYSCgixvlN3zbIRP5ZO5lJzaFm5KNbMfsogoc7KWKeq%2FDDJGqY41uyTx59ICbKDNlQMEoLh%2BRC8RoDtqtooTae09whVh3DredEYzFemya1gYpcX1dEtjdKaukuqv3ns4ZMgbkVR%2BaWKgUwcNEFMyiU%2F2Htf4ItzoMGSRhebBs%2FWF9GiM%2FkgjmNxnGbPBhjKLmGMdDyjAqDp0GzmiOb8T&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20240114T190057Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFH4WBDDOE%2F20240114%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=8b8cdfbfc2c0d456e2c71c5e3b9559912861afefab1c4ad52808f6b095f2b6e0\",\n" +
    "        \"width\": 600,\n" +
    "        \"height\": 600\n" +
    "      }\n" +
    "    },\n" +
    "    \"source\": \"Smitten Kitchen\",\n" +
    "    \"url\": \"http://smittenkitchen.com/2007/08/my-favorite-side-dish/\",\n" +
    "    \"shareAs\": \"http://www.edamam.com/recipe/quick-zucchini-saut%C3%A9-e4f821c4563a12e2a9ee24ba48ae2c4e/-\",\n" +
    "    \"yield\": 5,\n" +
    "    \"dietLabels\": [\n" +
    "      \"Low-Carb\",\n" +
    "      \"Low-Sodium\"\n" +
    "    ],\n" +
    "    \"healthLabels\": [\n" +
    "      \"Sugar-Conscious\",\n" +
    "      \"Low Potassium\",\n" +
    "      \"Kidney-Friendly\",\n" +
    "      \"Keto-Friendly\",\n" +
    "      \"Vegetarian\",\n" +
    "      \"Pescatarian\",\n" +
    "      \"Mediterranean\",\n" +
    "      \"Gluten-Free\",\n" +
    "      \"Wheat-Free\",\n" +
    "      \"Egg-Free\",\n" +
    "      \"Peanut-Free\",\n" +
    "      \"Soy-Free\",\n" +
    "      \"Fish-Free\",\n" +
    "      \"Shellfish-Free\",\n" +
    "      \"Pork-Free\",\n" +
    "      \"Red-Meat-Free\",\n" +
    "      \"Crustacean-Free\",\n" +
    "      \"Celery-Free\",\n" +
    "      \"Mustard-Free\",\n" +
    "      \"Sesame-Free\",\n" +
    "      \"Lupine-Free\",\n" +
    "      \"Mollusk-Free\",\n" +
    "      \"Alcohol-Free\",\n" +
    "      \"Sulfite-Free\",\n" +
    "      \"FODMAP-Free\",\n" +
    "      \"Kosher\",\n" +
    "      \"Immuno-Supportive\"\n" +
    "    ], \"cautions\": [\n" +
    "      \"Sulfites\"\n" +
    "    ],\n" +
    "    \"ingredientLines\": [\n" +
    "      \"2 tablespoons olive oil\",\n" +
    "      \"2 tablespoons thinly sliced almonds\",\n" +
    "      \"1 to 2 small zucchini, cut into 1/8-inch matchsticks with a knife or julienne blade on a mandoline\",\n" +
    "      \"Salt and freshly ground pepper\",\n" +
    "      \"Few ounces pecorino Romano or paremsan, in thin slices — a peeler works great for this\"\n" +
    "    ],\n" +
    "    \"ingredients\": [\n" +
    "      {\n" +
    "        \"text\": \"2 tablespoons olive oil\",\n" +
    "        \"quantity\": 2,\n" +
    "        \"measure\": \"tablespoon\",\n" +
    "        \"food\": \"olive oil\",\n" +
    "        \"weight\": 27,\n" +
    "        \"foodCategory\": \"Oils\",\n" +
    "        \"foodId\": \"food_b1d1icuad3iktrbqby0hiagafaz7\",\n" +
    "        \"image\": \"https://www.edamam.com/food-img/4d6/4d651eaa8a353647746290c7a9b29d84.jpg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"text\": \"2 tablespoons thinly sliced almonds\",\n" +
    "        \"quantity\": 2,\n" +
    "        \"measure\": \"tablespoon\",\n" +
    "        \"food\": \"almonds\",\n" +
    "        \"weight\": 17.87499999969778,\n" +
    "        \"foodCategory\": \"plant-based protein\",\n" +
    "        \"foodId\": \"food_bq4d2wras281i0br37nrnaglo3yc\",\n" +
    "        \"image\": \"https://www.edamam.com/food-img/6c2/6c2dc21adf11afc4c8d390ee2f651e56.jpg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"text\": \"1 to 2 small zucchini, cut into 1/8-inch matchsticks with a knife or julienne blade on a mandoline\",\n" +
    "        \"quantity\": 1.5,\n" +
    "        \"measure\": \"<unit>\",\n" +
    "        \"food\": \"zucchini\",\n" +
    "        \"weight\": 177,\n" +
    "        \"foodCategory\": \"vegetables\",\n" +
    "        \"foodId\": \"food_avpihljbuwpd8ibbmahcabaros5s\",\n" +
    "        \"image\": \"https://www.edamam.com/food-img/f63/f637280594e4a731eccc1199194a8847.jpg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"text\": \"Salt and freshly ground pepper\",\n" +
    "        \"quantity\": 0,\n" +
    "        \"measure\": null,\n" +
    "        \"food\": \"Salt\",\n" +
    "        \"weight\": 1.5013471387481865,\n" +
    "        \"foodCategory\": \"Condiments and sauces\",\n" +
    "        \"foodId\": \"food_btxz81db72hwbra2pncvebzzzum9\",\n" +
    "        \"image\": \"https://www.edamam.com/food-img/694/6943ea510918c6025795e8dc6e6eaaeb.jpg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"text\": \"Salt and freshly ground pepper\",\n" +
    "        \"quantity\": 0,\n" +
    "        \"measure\": null,\n" +
    "        \"food\": \"pepper\",\n" +
    "        \"weight\": 0.7506735693740932,\n" +
    "        \"foodCategory\": \"Condiments and sauces\",\n" +
    "        \"foodId\": \"food_b6ywzluaaxv02wad7s1r9ag4py89\",\n" +
    "        \"image\": \"https://www.edamam.com/food-img/c6e/c6e5c3bd8d3bc15175d9766971a4d1b2.jpg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"text\": \"Few ounces pecorino Romano or paremsan, in thin slices — a peeler works great for this\",\n" +
    "        \"quantity\": 1,\n" +
    "        \"measure\": \"ounce\",\n" +
    "        \"food\": \"pecorino Romano\",\n" +
    "        \"weight\": 28.349523125,\n" +
    "        \"foodCategory\": \"Cheese\",\n" +
    "        \"foodId\": \"food_bmxguz9abbdnfvbuklp2mbsrpt6b\",\n" +
    "        \"image\": \"https://www.edamam.com/food-img/71a/71a53d043eded9a8914415178a07f879.jpg\"\n" +
    "      }\n" +
    "    ],\n" +
    "    \"calories\": 483.86309515112913,\n" +
    "    \"totalCO2Emissions\": 941.3767660364613,\n" +
    "    \"co2EmissionsClass\": \"C\",\n" +
    "    \"totalWeight\": 251.39584291831608,\n" +
    "    \"totalTime\": 0,\n" +
    "    \"cuisineType\": [\n" +
    "      \"mediterranean\"\n" +
    "    ],\n" +
    "    \"mealType\": [\n" +
    "      \"lunch/dinner\"\n" +
    "    ],\n" +
    "    \"dishType\": [\n" +
    "      \"starter\"\n" +
    "    ], \"totalNutrients\": {\n" +
    "      \"ENERC_KCAL\": {\n" +
    "        \"label\": \"Energy\",\n" +
    "        \"quantity\": 483.86309515112913,\n" +
    "        \"unit\": \"kcal\"\n" +
    "      },\n" +
    "      \"FAT\": {\n" +
    "        \"label\": \"Fat\",\n" +
    "        \"quantity\": 44.136518678835785,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      \"FASAT\": {\n" +
    "        \"label\": \"Saturated\",\n" +
    "        \"quantity\": 9.412132816977817,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      \"FATRN\": {\n" +
    "        \"label\": \"Trans\",\n" +
    "        \"quantity\": 0.002681249999954668,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      \"FAMS\": {\n" +
    "        \"label\": \"Monounsaturated\",\n" +
    "        \"quantity\": 27.606120090582174,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      \"FAPU\": {\n" +
    "        \"label\": \"Polyunsaturated\",\n" +
    "        \"quantity\": 5.37029939431643,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      \"CHOCDF\": {\n" +
    "        \"label\": \"Carbs\",\n" +
    "        \"quantity\": 10.875218773771639,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      \"CHOCDF.net\": {\n" +
    "        \"label\": \"Carbohydrates (net)\",\n" +
    "        \"quantity\": 6.680923360757774,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      \"FIBTG\": {\n" +
    "        \"label\": \"Fiber\",\n" +
    "        \"quantity\": 4.194295413013868,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      \"SUGAR\": {\n" +
    "        \"label\": \"Sugars\",\n" +
    "        \"quantity\": 5.414318329643347,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      \"PROCNT\": {\n" +
    "        \"label\": \"Protein\",\n" +
    "        \"quantity\": 15.024418404900837,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      \"CHOLE\": {\n" +
    "        \"label\": \"Cholesterol\",\n" +
    "        \"quantity\": 29.48350405,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"NA\": {\n" +
    "        \"label\": \"Sodium\",\n" +
    "        \"quantity\": 583.6378004081303,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"CA\": {\n" +
    "        \"label\": \"Calcium\",\n" +
    "        \"quantity\": 380.6051341303329,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"MG\": {\n" +
    "        \"label\": \"Magnesium\",\n" +
    "        \"quantity\": 93.03366274630616,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"K\": {\n" +
    "        \"label\": \"Potassium\",\n" +
    "        \"quantity\": 627.6619500558998,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"FE\": {\n" +
    "        \"label\": \"Iron\",\n" +
    "        \"quantity\": 1.7618323641775184,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"ZN\": {\n" +
    "        \"label\": \"Zinc\",\n" +
    "        \"quantity\": 1.864871358315367,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"P\": {\n" +
    "        \"label\": \"Phosphorus\",\n" +
    "        \"quantity\": 369.8811899881574,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"VITA_RAE\": {\n" +
    "        \"label\": \"Vitamin A\",\n" +
    "        \"quantity\": 45.118224063731006,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      \"VITC\": {\n" +
    "        \"label\": \"Vitamin C\",\n" +
    "        \"quantity\": 31.682999999999993,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"THIA\": {\n" +
    "        \"label\": \"Thiamin (B1)\",\n" +
    "        \"quantity\": 0.12759380101055448,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"RIBF\": {\n" +
    "        \"label\": \"Riboflavin (B2)\",\n" +
    "        \"quantity\": 0.4763994479839281,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"NIA\": {\n" +
    "        \"label\": \"Niacin (B3)\",\n" +
    "        \"quantity\": 1.4757318114861744,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"VITB6A\": {\n" +
    "        \"label\": \"Vitamin B6\",\n" +
    "        \"quantity\": 0.33928030474271453,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"FOLDFE\": {\n" +
    "        \"label\": \"Folate equivalent (total)\",\n" +
    "        \"quantity\": 52.457081125410625,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      \"FOLFD\": {\n" +
    "        \"label\": \"Folate (food)\",\n" +
    "        \"quantity\": 52.457081125410625,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      \"FOLAC\": {\n" +
    "        \"label\": \"Folic acid\",\n" +
    "        \"quantity\": 0,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      \"VITB12\": {\n" +
    "        \"label\": \"Vitamin B12\",\n" +
    "        \"quantity\": 0.3175146590000001,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      \"VITD\": {\n" +
    "        \"label\": \"Vitamin D\",\n" +
    "        \"quantity\": 0.14174761562500002,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      \"TOCPHA\": {\n" +
    "        \"label\": \"Vitamin E\",\n" +
    "        \"quantity\": 8.749410908231624,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      \"VITK1\": {\n" +
    "        \"label\": \"Vitamin K\",\n" +
    "        \"quantity\": 25.719794162523513,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      \"WATER\": {\n" +
    "        \"label\": \"Water\",\n" +
    "        \"quantity\": 177.43896563423192,\n" +
    "        \"unit\": \"g\"\n" +
    "      }\n" +
    "    },\n" +
    "    \"totalDaily\": {\n" +
    "      \"ENERC_KCAL\": {\n" +
    "        \"label\": \"Energy\",\n" +
    "        \"quantity\": 24.193154757556457,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"FAT\": {\n" +
    "        \"label\": \"Fat\",\n" +
    "        \"quantity\": 67.90233642897813,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"FASAT\": {\n" +
    "        \"label\": \"Saturated\",\n" +
    "        \"quantity\": 47.06066408488908,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"CHOCDF\": {\n" +
    "        \"label\": \"Carbs\",\n" +
    "        \"quantity\": 3.6250729245905466,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"FIBTG\": {\n" +
    "        \"label\": \"Fiber\",\n" +
    "        \"quantity\": 16.77718165205547,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"PROCNT\": {\n" +
    "        \"label\": \"Protein\",\n" +
    "        \"quantity\": 30.048836809801674,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"CHOLE\": {\n" +
    "        \"label\": \"Cholesterol\",\n" +
    "        \"quantity\": 9.827834683333334,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"NA\": {\n" +
    "        \"label\": \"Sodium\",\n" +
    "        \"quantity\": 24.318241683672095,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"CA\": {\n" +
    "        \"label\": \"Calcium\",\n" +
    "        \"quantity\": 38.06051341303329,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"MG\": {\n" +
    "        \"label\": \"Magnesium\",\n" +
    "        \"quantity\": 22.150872082453848,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"K\": {\n" +
    "        \"label\": \"Potassium\",\n" +
    "        \"quantity\": 13.35450957565744,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"FE\": {\n" +
    "        \"label\": \"Iron\",\n" +
    "        \"quantity\": 9.787957578763992,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"ZN\": {\n" +
    "        \"label\": \"Zinc\",\n" +
    "        \"quantity\": 16.953375984685156,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"P\": {\n" +
    "        \"label\": \"Phosphorus\",\n" +
    "        \"quantity\": 52.840169998308205,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"VITA_RAE\": {\n" +
    "        \"label\": \"Vitamin A\",\n" +
    "        \"quantity\": 5.013136007081223,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"VITC\": {\n" +
    "        \"label\": \"Vitamin C\",\n" +
    "        \"quantity\": 35.203333333333326,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"THIA\": {\n" +
    "        \"label\": \"Thiamin (B1)\",\n" +
    "        \"quantity\": 10.632816750879542,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"RIBF\": {\n" +
    "        \"label\": \"Riboflavin (B2)\",\n" +
    "        \"quantity\": 36.646111383379086,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"NIA\": {\n" +
    "        \"label\": \"Niacin (B3)\",\n" +
    "        \"quantity\": 9.22332382178859,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"VITB6A\": {\n" +
    "        \"label\": \"Vitamin B6\",\n" +
    "        \"quantity\": 26.09848498020881,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"FOLDFE\": {\n" +
    "        \"label\": \"Folate equivalent (total)\",\n" +
    "        \"quantity\": 13.114270281352656,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"VITB12\": {\n" +
    "        \"label\": \"Vitamin B12\",\n" +
    "        \"quantity\": 13.229777458333338,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"VITD\": {\n" +
    "        \"label\": \"Vitamin D\",\n" +
    "        \"quantity\": 0.9449841041666668,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"TOCPHA\": {\n" +
    "        \"label\": \"Vitamin E\",\n" +
    "        \"quantity\": 58.329406054877495,\n" +
    "        \"unit\": \"%\"\n" +
    "      },\n" +
    "      \"VITK1\": {\n" +
    "        \"label\": \"Vitamin K\",\n" +
    "        \"quantity\": 21.433161802102926,\n" +
    "        \"unit\": \"%\"\n" +
    "      }\n" +
    "    }" +
    " ,\n" +
    "    \"digest\": [\n" +
    "      {\n" +
    "        \"label\": \"Fat\",\n" +
    "        \"tag\": \"FAT\",\n" +
    "        \"schemaOrgTag\": \"fatContent\",\n" +
    "        \"total\": 44.136518678835785,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 67.90233642897813,\n" +
    "        \"unit\": \"g\",\n" +
    "        \"sub\": [\n" +
    "          {\n" +
    "            \"label\": \"Saturated\",\n" +
    "            \"tag\": \"FASAT\",\n" +
    "            \"schemaOrgTag\": \"saturatedFatContent\",\n" +
    "            \"total\": 9.412132816977817,\n" +
    "            \"hasRDI\": true,\n" +
    "            \"daily\": 47.06066408488908,\n" +
    "            \"unit\": \"g\"\n" +
    "          },\n" +
    "          {\n" +
    "            \"label\": \"Trans\",\n" +
    "            \"tag\": \"FATRN\",\n" +
    "            \"schemaOrgTag\": \"transFatContent\",\n" +
    "            \"total\": 0.002681249999954668,\n" +
    "            \"hasRDI\": false,\n" +
    "            \"daily\": 0,\n" +
    "            \"unit\": \"g\"\n" +
    "          },\n" +
    "          {\n" +
    "            \"label\": \"Monounsaturated\",\n" +
    "            \"tag\": \"FAMS\",\n" +
    "            \"schemaOrgTag\": null,\n" +
    "            \"total\": 27.606120090582174,\n" +
    "            \"hasRDI\": false,\n" +
    "            \"daily\": 0,\n" +
    "            \"unit\": \"g\"\n" +
    "          },\n" +
    "          {\n" +
    "            \"label\": \"Polyunsaturated\",\n" +
    "            \"tag\": \"FAPU\",\n" +
    "            \"schemaOrgTag\": null,\n" +
    "            \"total\": 5.37029939431643,\n" +
    "            \"hasRDI\": false,\n" +
    "            \"daily\": 0,\n" +
    "            \"unit\": \"g\"\n" +
    "          }\n" +
    "        ]\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Carbs\",\n" +
    "        \"tag\": \"CHOCDF\",\n" +
    "        \"schemaOrgTag\": \"carbohydrateContent\",\n" +
    "        \"total\": 10.875218773771639,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 3.6250729245905466,\n" +
    "        \"unit\": \"g\",\n" +
    "        \"sub\": [\n" +
    "          {\n" +
    "            \"label\": \"Carbs (net)\",\n" +
    "            \"tag\": \"CHOCDF.net\",\n" +
    "            \"schemaOrgTag\": null,\n" +
    "            \"total\": 6.680923360757774,\n" +
    "            \"hasRDI\": false,\n" +
    "            \"daily\": 0,\n" +
    "            \"unit\": \"g\"\n" +
    "          },\n" +
    "          {\n" +
    "            \"label\": \"Fiber\",\n" +
    "            \"tag\": \"FIBTG\",\n" +
    "            \"schemaOrgTag\": \"fiberContent\",\n" +
    "            \"total\": 4.194295413013868,\n" +
    "            \"hasRDI\": true,\n" +
    "            \"daily\": 16.77718165205547,\n" +
    "            \"unit\": \"g\"\n" +
    "          },\n" +
    "          {\n" +
    "            \"label\": \"Sugars\",\n" +
    "            \"tag\": \"SUGAR\",\n" +
    "            \"schemaOrgTag\": \"sugarContent\",\n" +
    "            \"total\": 5.414318329643347,\n" +
    "            \"hasRDI\": false,\n" +
    "            \"daily\": 0,\n" +
    "            \"unit\": \"g\"\n" +
    "          },\n" +
    "          {\n" +
    "            \"label\": \"Sugars, added\",\n" +
    "            \"tag\": \"SUGAR.added\",\n" +
    "            \"schemaOrgTag\": null,\n" +
    "            \"total\": 0,\n" +
    "            \"hasRDI\": false,\n" +
    "            \"daily\": 0,\n" +
    "            \"unit\": \"g\"\n" +
    "          }\n" +
    "        ]\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Protein\",\n" +
    "        \"tag\": \"PROCNT\",\n" +
    "        \"schemaOrgTag\": \"proteinContent\",\n" +
    "        \"total\": 15.024418404900837,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 30.048836809801674,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Cholesterol\",\n" +
    "        \"tag\": \"CHOLE\",\n" +
    "        \"schemaOrgTag\": \"cholesterolContent\",\n" +
    "        \"total\": 29.48350405,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 9.827834683333334,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Sodium\",\n" +
    "        \"tag\": \"NA\",\n" +
    "        \"schemaOrgTag\": \"sodiumContent\",\n" +
    "        \"total\": 583.6378004081303,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 24.318241683672095,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Calcium\",\n" +
    "        \"tag\": \"CA\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 380.6051341303329,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 38.06051341303329,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Magnesium\",\n" +
    "        \"tag\": \"MG\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 93.03366274630616,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 22.150872082453848,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Potassium\",\n" +
    "        \"tag\": \"K\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 627.6619500558998,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 13.35450957565744,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Iron\",\n" +
    "        \"tag\": \"FE\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 1.7618323641775184,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 9.787957578763992,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Zinc\",\n" +
    "        \"tag\": \"ZN\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 1.864871358315367,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 16.953375984685156,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Phosphorus\",\n" +
    "        \"tag\": \"P\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 369.8811899881574,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 52.840169998308205,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Vitamin A\",\n" +
    "        \"tag\": \"VITA_RAE\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 45.118224063731006,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 5.013136007081223,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Vitamin C\",\n" +
    "        \"tag\": \"VITC\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 31.682999999999993,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 35.203333333333326,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Thiamin (B1)\",\n" +
    "        \"tag\": \"THIA\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 0.12759380101055448,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 10.632816750879542,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Riboflavin (B2)\",\n" +
    "        \"tag\": \"RIBF\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 0.4763994479839281,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 36.646111383379086,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Niacin (B3)\",\n" +
    "        \"tag\": \"NIA\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 1.4757318114861744,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 9.22332382178859,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Vitamin B6\",\n" +
    "        \"tag\": \"VITB6A\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 0.33928030474271453,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 26.09848498020881,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Folate equivalent (total)\",\n" +
    "        \"tag\": \"FOLDFE\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 52.457081125410625,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 13.114270281352656,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Folate (food)\",\n" +
    "        \"tag\": \"FOLFD\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 52.457081125410625,\n" +
    "        \"hasRDI\": false,\n" +
    "        \"daily\": 0,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Folic acid\",\n" +
    "        \"tag\": \"FOLAC\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 0,\n" +
    "        \"hasRDI\": false,\n" +
    "        \"daily\": 0,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Vitamin B12\",\n" +
    "        \"tag\": \"VITB12\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 0.3175146590000001,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 13.229777458333338,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Vitamin D\",\n" +
    "        \"tag\": \"VITD\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 0.14174761562500002,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 0.9449841041666668,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Vitamin E\",\n" +
    "        \"tag\": \"TOCPHA\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 8.749410908231624,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 58.329406054877495,\n" +
    "        \"unit\": \"mg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Vitamin K\",\n" +
    "        \"tag\": \"VITK1\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 25.719794162523513,\n" +
    "        \"hasRDI\": true,\n" +
    "        \"daily\": 21.433161802102926,\n" +
    "        \"unit\": \"µg\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Sugar alcohols\",\n" +
    "        \"tag\": \"Sugar.alcohol\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 0,\n" +
    "        \"hasRDI\": false,\n" +
    "        \"daily\": 0,\n" +
    "        \"unit\": \"g\"\n" +
    "      },\n" +
    "      {\n" +
    "        \"label\": \"Water\",\n" +
    "        \"tag\": \"WATER\",\n" +
    "        \"schemaOrgTag\": null,\n" +
    "        \"total\": 177.43896563423192,\n" +
    "        \"hasRDI\": false,\n" +
    "        \"daily\": 0,\n" +
    "        \"unit\": \"g\"\n" +
    "      }]" +
    "}";*/
/*
//        try {
//            // Send the request and retrieve the response
//            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

////            String jsonPretty = gson.fromJson(response.body(), String.class);
////
////            List<Recipe> recipes = recipeList.getHits().stream()
////                .map(Hit::getRecipe)
////                .collect(Collectors.toList());
        // Print the response body

//            Gson gson = new GsonBuilder().setLenient().create();

//            Recipe recipe = gson.fromJson(response.toString(), Recipe.class);
//            System.out.println(recipe.getLabel());
//            System.out.println(recipe.getHealthLabels());

//            System.out.println("Response Code: " + response.statusCode());
//            System.out.println("Response Body: " + response.body());

//            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

//            JsonObject jsonObject = jsonReader.parseString(response.toString()).getAsJsonObject();

        // Get the "hits" array
//            JsonArray hitsArray = jsonObject.getAsJsonArray("hits");

//            System.out.println(hitsArray.size());

//            for (int i = 0; i < hitsArray.size(); i++) {
////                JsonObject hitObject = hitsArray.get(i).getAsJsonObject();
//                JsonObject hitObject = hitsArray.get(i).getAsJsonObject();
//                JsonObject recipeObject = hitObject.getAsJsonObject("recipe");

//                Recipe recipe = gson.fromJson(recipeObject.toString(), Recipe.class);
//                System.out.println(recipe.toString());
//                System.out.println(recipeObject.get("label"));
//                System.out.println(recipeObject.get("dietLabels"));
//                System.out.println(recipeObject.get("healthLabels"));
//                System.out.println(recipeObject.get("totalWeight"));
//                System.out.println(recipeObject.get("cuisineType"));
//                System.out.println(recipeObject.get("mealType"));
//                System.out.println(recipeObject.get("dishType"));
//                System.out.println(recipeObject.get("ingredientLines"));

//                System.out.println('\n');
//            }


//////            System.out.println("Response Body: " + jsonPretty);
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

        //String[] validDataTypes = new String[]{"alcohol-free", "celery-free", "crustacean-free", "dairy-free", "egg-free", "fish-free",
        //    "fodmap-free", "gluten-free", "immuno-supportive", "keto-friendly", "kidney-friendly", "kosher", "low-fat-abs",
        //    "low-potassium", "low-sugar", "lupine-free", "Mediterranean", "mollusk-free", "mustard-free", "no-oil-added", "paleo",
        //    "peanut-free", "pescatarian", "pork-free", "red-meat-free", "sesame-free", "shellfish-free", "soy-free", "sugar-conscious",
        //    "sulfite-free", "tree-nut-free", "vegan", "vegetarian", "wheat-free"};
*/

        System.out.println("Hello World!");
    }
}