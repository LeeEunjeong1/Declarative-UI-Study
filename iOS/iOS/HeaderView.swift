//
//  HeaderView.swift
//  iOS
//
//  Created by Financial CB on 2023/07/11.
//

import SwiftUI

struct HeaderView<Left, Center, Right>: View where Left: View, Center: View, Right: View {
    let left: () -> Left
    let center: () -> Center
    let right: () -> Right
    
    init(@ViewBuilder left: @escaping () -> Left,
         @ViewBuilder center: @escaping () -> Center,
         @ViewBuilder right: @escaping () -> Right) {
        self.left = left
        self.center = center
        self.right = right
    }
    
    var body: some View {
        HStack {
            left()
            Spacer()
            center()
            Spacer()
            right()
            
            Image(systemName: "magnifyingglass")
                .padding(5)
            Image(systemName: "bag")
        }
    }
}

struct HeaderView_Previews: PreviewProvider {
    static var previews: some View {
        HeaderView<<#Left: View#>, <#Center: View#>, <#Right: View#>>()
    }
}
