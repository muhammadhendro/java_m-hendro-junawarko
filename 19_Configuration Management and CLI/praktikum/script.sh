#! /bin/bash

dir="$1 at $(date)"

listFriend=$(curl -s "https://gist.githubusercontent.com/tegarimansyah/e91f335753ab2c7fb12815779677e914/raw/94864388379fecee450fde26e3e73bfb2bcda194/list%2520of%2520my%2520friends.txt")
ping=$(ping "google.com" -c 3)

mkdir -p "$dir"/{about_me/{personal,professional},my_friends,my_system_info}
cd "$dir/about_me/personal" && echo "https://www.facebook.com/$2" > facebook.txt
cd "../professional" && echo "https://www.linkedin.com/in/$3" > linkedin.txt
cd "../../my_friends" && echo "$listFriend" > list_of_my_friends.txt
cd "../my_system_info" &&  printf "My username: $(whoami)\nWith host: $(uname -a)" > about_this_laptop.txt && echo "$ping" > internet_connection.txt
